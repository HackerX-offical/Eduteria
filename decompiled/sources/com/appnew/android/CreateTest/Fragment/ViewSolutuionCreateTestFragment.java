package com.appnew.android.CreateTest.Fragment;

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
import com.appnew.android.testmodule.model.Answers;
import com.appnew.android.testmodule.model.FIBEdit;
import com.appnew.android.testmodule.model.Question;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ViewSolutuionCreateTestFragment extends MainFragment implements Html.ImageGetter {
    private static final String TAG = "ViewSolutionFragment";
    LinearLayout LLmatchinquestion;
    List<View> LinearLayoutList;
    Answers answers;
    private Drawable empty;
    private Drawable empty2;
    LinearLayout explanationLL;
    ClickableWebView explanationTV;
    Progress mProgress;
    LinearLayout mcqoptionsLL;
    NestedScrollView nestedSV;
    LinearLayout parentLL;
    List<View> parentList;
    int position;
    String questionType;
    TextView question_status;
    RelativeLayout questionsol_layout1;
    Question result;
    RecyclerView rvmatchinquestion1;
    RecyclerView rvmatchinquestion2;
    int selectedAnswerposition;
    private boolean status;
    List<View> tvList;
    private ClickableWebView tvQuestion;
    private ClickableWebView tvQuestionFib;
    TextView tv_uid;
    TextView userEmailTV;
    TextView videosolution;
    TestseriesBase viewSolutionData;
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

    public static ViewSolutuionCreateTestFragment newInstance(int position, TestseriesBase testseriesBase, String questionType, Answers answers, String s) {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.POSITION, position);
        bundle.putString("questionType", questionType);
        bundle.putSerializable("testseriesBase", testseriesBase);
        bundle.putSerializable(Const.ANSWERS, answers);
        bundle.putSerializable("lang", s);
        ViewSolutuionCreateTestFragment viewSolutuionCreateTestFragment = new ViewSolutuionCreateTestFragment();
        viewSolutuionCreateTestFragment.setArguments(bundle);
        return viewSolutuionCreateTestFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_create_test_solution, (ViewGroup) null);
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
            this.viewSolutionData = (TestseriesBase) arguments.getSerializable("testseriesBase");
            String string = arguments.getString("lang", "");
            if (string.equalsIgnoreCase("E/H")) {
                this.result = this.viewSolutionData.getData().getQuestionsHindi().get(this.position);
            } else if (string.equalsIgnoreCase("H/E")) {
                this.result = this.viewSolutionData.getData().getQuestions().get(this.position);
            } else {
                this.result = this.viewSolutionData.getData().getQuestions().get(this.position);
            }
            this.answers = (Answers) arguments.getSerializable(Const.ANSWERS);
            this.questionType = arguments.getString("questionType", "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private void initView(View view) {
        this.mcqoptionsLL = (LinearLayout) view.findViewById(R.id.mcqoptions);
        this.tvQuestion = (ClickableWebView) view.findViewById(R.id.tv_question);
        this.videosolution = (TextView) view.findViewById(R.id.videosolution);
        this.questionsol_layout1 = (RelativeLayout) view.findViewById(R.id.questionsol_layout1);
        this.LLmatchinquestion = (LinearLayout) view.findViewById(R.id.LLmatchinquestion);
        this.rvmatchinquestion1 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion1);
        this.rvmatchinquestion2 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion2);
        this.explanationTV = (ClickableWebView) view.findViewById(R.id.explanationTV);
        this.explanationLL = (LinearLayout) view.findViewById(R.id.explanationLL);
        this.rvmatchinquestion1.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setHasFixedSize(true);
        this.tv_uid = (TextView) view.findViewById(R.id.tv_uid);
        this.your_ans_text = (TextView) view.findViewById(R.id.your_ans);
        this.question_status = (TextView) view.findViewById(R.id.question_status);
        this.nestedSV = (NestedScrollView) view.findViewById(R.id.nestedSV);
        this.userEmailTV = (TextView) view.findViewById(R.id.userEmailTV);
        this.tvQuestionFib = (ClickableWebView) view.findViewById(R.id.tv_question_fib);
        this.LinearLayoutList = new ArrayList();
        this.parentList = new ArrayList();
        this.tvList = new ArrayList();
        this.tvQuestion.setLayerType(2, null);
        if (Helper.isStringValid(this.result.getSolution_url())) {
            this.videosolution.setVisibility(0);
        } else {
            this.videosolution.setVisibility(8);
        }
        this.videosolution.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.CreateTest.Fragment.ViewSolutuionCreateTestFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initView$0();
            }
        }));
        if (!TextUtils.isEmpty(this.result.getDescription())) {
            this.explanationLL.setVisibility(0);
            this.explanationTV.setBackgroundColor(0);
            this.tvQuestion.setLayerType(2, null);
            this.tvQuestion.getSettings().setJavaScriptEnabled(true);
            this.explanationTV.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(this.explanationTV, this.result.getDescription());
            this.explanationTV.setLongClickable(false);
            this.explanationTV.setOnLongClickListener(new WebViewClickListener_option(this.explanationTV, this.explanationLL));
        } else {
            this.explanationLL.setVisibility(8);
        }
        if (this.result.getParagraphText() == null || TextUtils.isEmpty(this.result.getParagraphText())) {
            this.tvQuestionFib.setVisibility(8);
        } else {
            this.tvQuestionFib.setVisibility(0);
            Helper.TestWebHTMLLoad(this.tvQuestionFib, this.result.getParagraphText());
        }
        String str = this.questionType;
        str.hashCode();
        if (str.equals("FIB")) {
            String strReplace = this.result.getQuestion().replace("FIB", ".....");
            this.tvQuestion.requestFocus();
            this.tvQuestion.getSettings().setLightTouchEnabled(true);
            this.tvQuestion.setBackgroundColor(0);
            this.tvQuestion.setLayerType(2, null);
            this.tvQuestion.getSettings().setJavaScriptEnabled(true);
            this.tvQuestion.getSettings().setGeolocationEnabled(true);
            Helper.TestWebHTMLLoad(this.tvQuestion, "Q-" + (this.position + 1) + ". " + strReplace);
            this.tvQuestion.setLongClickable(false);
            this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
            addQuestionOptionForFIB();
        } else {
            this.mcqoptionsLL.setVisibility(0);
            this.LLmatchinquestion.setVisibility(8);
            String question = this.result.getQuestion();
            this.tvQuestion.setBackgroundColor(0);
            this.tvQuestion.setLayerType(2, null);
            this.tvQuestion.getSettings().setJavaScriptEnabled(true);
            this.tvQuestion.getSettings().setGeolocationEnabled(true);
            Helper.TestWebHTMLLoad(this.tvQuestion, "Q-" + (this.position + 1) + ". " + question);
            this.tvQuestion.setLongClickable(false);
            this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
            addSolutionOption();
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

    public int countFIBWords(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.substring(i2).startsWith("FIB")) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0391, code lost:
    
        if (java.lang.Integer.parseInt(r24.result.getIsCorrect()) == 1) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x03e0, code lost:
    
        if (java.lang.Integer.parseInt(r24.result.getIsCorrect()) == 1) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0436, code lost:
    
        if (java.lang.Integer.parseInt(r24.result.getIsCorrect()) == 1) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0484, code lost:
    
        if (java.lang.Integer.parseInt(r24.result.getIsCorrect()) == 1) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x04dd, code lost:
    
        if (java.lang.Integer.parseInt(r24.result.getIsCorrect()) == 1) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x04df, code lost:
    
        r23 = r3;
        r13 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x04e5, code lost:
    
        r23 = r3;
        r13 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x033b, code lost:
    
        if (java.lang.Integer.parseInt(r24.result.getIsCorrect()) == 1) goto L135;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:246:0x09ef A[PHI: r13 r22 r23
      0x09ef: PHI (r13v24 java.lang.String) = 
      (r13v4 java.lang.String)
      (r13v4 java.lang.String)
      (r13v5 java.lang.String)
      (r13v5 java.lang.String)
      (r13v6 java.lang.String)
      (r13v6 java.lang.String)
      (r13v7 java.lang.String)
      (r13v7 java.lang.String)
      (r13v8 java.lang.String)
      (r13v8 java.lang.String)
      (r13v9 java.lang.String)
      (r13v9 java.lang.String)
      (r13v10 java.lang.String)
      (r13v10 java.lang.String)
      (r13v11 java.lang.String)
      (r13v11 java.lang.String)
      (r13v25 java.lang.String)
     binds: [B:245:0x09b6, B:238:0x0999, B:231:0x0916, B:224:0x08f7, B:217:0x0873, B:210:0x0854, B:203:0x07d0, B:196:0x07b1, B:189:0x072d, B:182:0x070e, B:175:0x068a, B:168:0x066b, B:161:0x05e7, B:154:0x05c8, B:147:0x0544, B:140:0x0525, B:132:0x04cc] A[DONT_GENERATE, DONT_INLINE]
      0x09ef: PHI (r22v15 java.lang.String) = 
      (r22v5 java.lang.String)
      (r22v5 java.lang.String)
      (r22v6 java.lang.String)
      (r22v6 java.lang.String)
      (r22v7 java.lang.String)
      (r22v7 java.lang.String)
      (r22v8 java.lang.String)
      (r22v8 java.lang.String)
      (r22v9 java.lang.String)
      (r22v9 java.lang.String)
      (r22v10 java.lang.String)
      (r22v10 java.lang.String)
      (r22v11 java.lang.String)
      (r22v11 java.lang.String)
      (r22v12 java.lang.String)
      (r22v12 java.lang.String)
      (r22v16 java.lang.String)
     binds: [B:245:0x09b6, B:238:0x0999, B:231:0x0916, B:224:0x08f7, B:217:0x0873, B:210:0x0854, B:203:0x07d0, B:196:0x07b1, B:189:0x072d, B:182:0x070e, B:175:0x068a, B:168:0x066b, B:161:0x05e7, B:154:0x05c8, B:147:0x0544, B:140:0x0525, B:132:0x04cc] A[DONT_GENERATE, DONT_INLINE]
      0x09ef: PHI (r23v10 java.lang.String) = 
      (r23v2 java.lang.String)
      (r23v2 java.lang.String)
      (r23v3 java.lang.String)
      (r23v3 java.lang.String)
      (r23v4 java.lang.String)
      (r23v4 java.lang.String)
      (r23v5 java.lang.String)
      (r23v5 java.lang.String)
      (r23v6 java.lang.String)
      (r23v6 java.lang.String)
      (r23v7 java.lang.String)
      (r23v7 java.lang.String)
      (r23v8 java.lang.String)
      (r23v8 java.lang.String)
      (r23v9 java.lang.String)
      (r23v9 java.lang.String)
      (r23v11 java.lang.String)
     binds: [B:245:0x09b6, B:238:0x0999, B:231:0x0916, B:224:0x08f7, B:217:0x0873, B:210:0x0854, B:203:0x07d0, B:196:0x07b1, B:189:0x072d, B:182:0x070e, B:175:0x068a, B:168:0x066b, B:161:0x05e7, B:154:0x05c8, B:147:0x0544, B:140:0x0525, B:132:0x04cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x09ff A[PHI: r13 r22 r23
      0x09ff: PHI (r13v26 java.lang.String) = 
      (r13v4 java.lang.String)
      (r13v4 java.lang.String)
      (r13v5 java.lang.String)
      (r13v5 java.lang.String)
      (r13v6 java.lang.String)
      (r13v6 java.lang.String)
      (r13v7 java.lang.String)
      (r13v7 java.lang.String)
      (r13v8 java.lang.String)
      (r13v8 java.lang.String)
      (r13v9 java.lang.String)
      (r13v9 java.lang.String)
      (r13v10 java.lang.String)
      (r13v10 java.lang.String)
      (r13v11 java.lang.String)
      (r13v11 java.lang.String)
      (r13v27 java.lang.String)
     binds: [B:248:0x09fd, B:241:0x09a7, B:233:0x095c, B:227:0x0906, B:219:0x08b9, B:213:0x0863, B:205:0x0816, B:199:0x07c0, B:191:0x0773, B:185:0x071d, B:177:0x06d0, B:171:0x067a, B:163:0x062d, B:157:0x05d7, B:149:0x058a, B:143:0x0534, B:135:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x09ff: PHI (r22v17 java.lang.String) = 
      (r22v5 java.lang.String)
      (r22v5 java.lang.String)
      (r22v6 java.lang.String)
      (r22v6 java.lang.String)
      (r22v7 java.lang.String)
      (r22v7 java.lang.String)
      (r22v8 java.lang.String)
      (r22v8 java.lang.String)
      (r22v9 java.lang.String)
      (r22v9 java.lang.String)
      (r22v10 java.lang.String)
      (r22v10 java.lang.String)
      (r22v11 java.lang.String)
      (r22v11 java.lang.String)
      (r22v12 java.lang.String)
      (r22v12 java.lang.String)
      (r22v18 java.lang.String)
     binds: [B:248:0x09fd, B:241:0x09a7, B:233:0x095c, B:227:0x0906, B:219:0x08b9, B:213:0x0863, B:205:0x0816, B:199:0x07c0, B:191:0x0773, B:185:0x071d, B:177:0x06d0, B:171:0x067a, B:163:0x062d, B:157:0x05d7, B:149:0x058a, B:143:0x0534, B:135:0x04df] A[DONT_GENERATE, DONT_INLINE]
      0x09ff: PHI (r23v12 java.lang.String) = 
      (r23v2 java.lang.String)
      (r23v2 java.lang.String)
      (r23v3 java.lang.String)
      (r23v3 java.lang.String)
      (r23v4 java.lang.String)
      (r23v4 java.lang.String)
      (r23v5 java.lang.String)
      (r23v5 java.lang.String)
      (r23v6 java.lang.String)
      (r23v6 java.lang.String)
      (r23v7 java.lang.String)
      (r23v7 java.lang.String)
      (r23v8 java.lang.String)
      (r23v8 java.lang.String)
      (r23v9 java.lang.String)
      (r23v9 java.lang.String)
      (r23v13 java.lang.String)
     binds: [B:248:0x09fd, B:241:0x09a7, B:233:0x095c, B:227:0x0906, B:219:0x08b9, B:213:0x0863, B:205:0x0816, B:199:0x07c0, B:191:0x0773, B:185:0x071d, B:177:0x06d0, B:171:0x067a, B:163:0x062d, B:157:0x05d7, B:149:0x058a, B:143:0x0534, B:135:0x04df] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0a02  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0e3f A[PHI: r6
      0x0e3f: PHI (r6v12 java.lang.String) = 
      (r6v3 java.lang.String)
      (r6v4 java.lang.String)
      (r6v5 java.lang.String)
      (r6v6 java.lang.String)
      (r6v7 java.lang.String)
      (r6v8 java.lang.String)
      (r6v9 java.lang.String)
      (r6v10 java.lang.String)
      (r6v11 java.lang.String)
      (r6v15 java.lang.String)
     binds: [B:336:0x0e3d, B:329:0x0de4, B:323:0x0d8d, B:317:0x0d35, B:311:0x0cdd, B:305:0x0c85, B:299:0x0c2d, B:293:0x0bd5, B:287:0x0b7d, B:281:0x0b25] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0e43 A[PHI: r6
      0x0e43: PHI (r6v13 java.lang.String) = 
      (r6v3 java.lang.String)
      (r6v4 java.lang.String)
      (r6v5 java.lang.String)
      (r6v6 java.lang.String)
      (r6v7 java.lang.String)
      (r6v8 java.lang.String)
      (r6v9 java.lang.String)
      (r6v10 java.lang.String)
      (r6v11 java.lang.String)
      (r6v15 java.lang.String)
     binds: [B:336:0x0e3d, B:329:0x0de4, B:323:0x0d8d, B:317:0x0d35, B:311:0x0cdd, B:305:0x0c85, B:299:0x0c2d, B:293:0x0bd5, B:287:0x0b7d, B:281:0x0b25] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0e44 A[PHI: r2 r15
      0x0e44: PHI (r2v12 java.lang.String) = 
      (r2v11 java.lang.String)
      (r2v11 java.lang.String)
      (r2v96 java.lang.String)
      (r2v11 java.lang.String)
      (r2v97 java.lang.String)
     binds: [B:274:0x0aca, B:275:0x0acc, B:337:0x0e3f, B:338:0x0e43, B:334:0x0e2e] A[DONT_GENERATE, DONT_INLINE]
      0x0e44: PHI (r15v2 java.lang.String) = 
      (r15v1 java.lang.String)
      (r15v1 java.lang.String)
      (r15v6 java.lang.String)
      (r15v7 java.lang.String)
      (r15v8 java.lang.String)
     binds: [B:274:0x0aca, B:275:0x0acc, B:337:0x0e3f, B:338:0x0e43, B:334:0x0e2e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void displaySolution() {
        /*
            Method dump skipped, instruction units count: 4006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.CreateTest.Fragment.ViewSolutuionCreateTestFragment.displaySolution():void");
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
                    if (this.result.getOption3() == null || this.result.getOption3().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("3", this.result.getOption3(), "11", false, i - 1));
                    }
                    break;
                case 4:
                    if (this.result.getOption4() == null || this.result.getOption4().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("4", this.result.getOption4(), "11", false, i - 1));
                    }
                    break;
                case 5:
                    if (this.result.getOption5() == null || this.result.getOption5().isEmpty()) {
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
        WebView webView = (WebView) linearLayout.findViewById(R.id.optionTextTV);
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
                    webView.getSettings().setJavaScriptEnabled(true);
                    Helper.TestWebHTMLLoad(webView, "Min value " + fIBEdit.getMin() + " Max value " + fIBEdit.getMax());
                    linearLayout.setSelected(true);
                } else if (fIBEdit.getType().equalsIgnoreCase(FirebaseAnalytics.Param.CHARACTER)) {
                    webView.getSettings().setJavaScriptEnabled(true);
                    Helper.TestWebHTMLLoad(webView, "Min text length " + fIBEdit.getMin() + " Max text length " + fIBEdit.getMax());
                    linearLayout.setSelected(true);
                } else {
                    webView.getSettings().setJavaScriptEnabled(true);
                    Helper.TestWebHTMLLoad(webView, fIBEdit.getAnswer());
                    linearLayout.setSelected(true);
                }
            }
        } else {
            webView.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(webView, str2);
        }
        webView.setLongClickable(false);
        webView.setOnLongClickListener(new WebViewClickListener_option(webView, linearLayout2));
        linearLayout.setTag(Integer.valueOf(i));
        this.textViews.add(webView);
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
                this.mDrawable.setBounds(0, 0, ViewSolutuionCreateTestFragment.this.empty.getIntrinsicWidth(), ViewSolutuionCreateTestFragment.this.empty.getIntrinsicHeight());
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
}
