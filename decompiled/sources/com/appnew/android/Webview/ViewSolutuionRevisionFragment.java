package com.appnew.android.Webview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Progress;
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
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ViewSolutuionRevisionFragment extends MainFragment implements Html.ImageGetter {
    private static final String TAG = "ViewSolutionFragment";
    LinearLayout LLmatchinquestion;
    List<View> LinearLayoutList;
    Answers answers;
    private Drawable empty;
    private Drawable empty2;
    Progress mProgress;
    LinearLayout mcqoptionsLL;
    NestedScrollView nestedSV;
    LinearLayout parentLL;
    List<View> parentList;
    int position;
    Question questionDump;
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
    TextView tv_uid;
    TextView userEmailTV;
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

    public static ViewSolutuionRevisionFragment newInstance(int position, TestseriesBase testseriesBase, String questionType, Answers answers) {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.POSITION, position);
        bundle.putString("questionType", questionType);
        bundle.putSerializable("testseriesBase", testseriesBase);
        bundle.putSerializable(Const.ANSWERS, answers);
        ViewSolutuionRevisionFragment viewSolutuionRevisionFragment = new ViewSolutuionRevisionFragment();
        viewSolutuionRevisionFragment.setArguments(bundle);
        return viewSolutuionRevisionFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_revision_solution, (ViewGroup) null);
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
            this.answers = (Answers) arguments.getSerializable(Const.ANSWERS);
            this.questionDump = this.viewSolutionData.getData().getQuestions().get(this.position);
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
        this.questionsol_layout1 = (RelativeLayout) view.findViewById(R.id.questionsol_layout1);
        this.LLmatchinquestion = (LinearLayout) view.findViewById(R.id.LLmatchinquestion);
        this.rvmatchinquestion1 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion1);
        this.rvmatchinquestion2 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion2);
        this.rvmatchinquestion1.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setHasFixedSize(true);
        this.tv_uid = (TextView) view.findViewById(R.id.tv_uid);
        this.your_ans_text = (TextView) view.findViewById(R.id.your_ans);
        this.question_status = (TextView) view.findViewById(R.id.question_status);
        this.nestedSV = (NestedScrollView) view.findViewById(R.id.nestedSV);
        this.userEmailTV = (TextView) view.findViewById(R.id.userEmailTV);
        this.LinearLayoutList = new ArrayList();
        this.parentList = new ArrayList();
        this.tvList = new ArrayList();
        this.result = this.viewSolutionData.getData().getQuestions().get(this.position);
        this.tvQuestion.setLayerType(2, null);
        this.questionType.hashCode();
        this.mcqoptionsLL.setVisibility(0);
        this.LLmatchinquestion.setVisibility(8);
        String question = this.viewSolutionData.getData().getQuestions().get(this.position).getQuestion();
        this.tvQuestion.setBackgroundColor(0);
        this.tvQuestion.setLayerType(2, null);
        this.tvQuestion.getSettings().setJavaScriptEnabled(true);
        this.tvQuestion.getSettings().setGeolocationEnabled(true);
        Helper.TestWebHTMLLoad(this.tvQuestion, "Q-" + (this.position + 1) + ". " + question);
        this.tvQuestion.setLongClickable(false);
        this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
        addSolutionOption();
        displaySolution();
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

    private void displaySolution() {
        String str;
        String str2 = "";
        if (this.answers.getState().equalsIgnoreCase("answered") && this.answers.getAnswers() != null) {
            String str3 = "";
            for (int i = 0; i < this.answers.getAnswers().size(); i++) {
                if (this.answers.getAnswers().get(i).toString().equalsIgnoreCase("1")) {
                    if (i == 0) {
                        str3 = str3 + "A,";
                    } else if (i == 1) {
                        str3 = str3 + "B,";
                    } else if (i == 2) {
                        str3 = str3 + "C,";
                    } else if (i == 3) {
                        str3 = str3 + "D,";
                    }
                }
            }
            this.your_ans_text.setText(str3);
        } else if (this.answers.getState().equalsIgnoreCase("not_visited")) {
            this.your_ans_text.setText(this.activity.getResources().getString(R.string.not_visited));
        } else {
            this.your_ans_text.setText(this.answers.getState());
        }
        String str4 = this.questionType;
        str4.hashCode();
        if (str4.equals("") || str4.equals("SC")) {
            if (this.answers.getState().equalsIgnoreCase("answered")) {
                String str5 = "";
                for (int i2 = 0; i2 < this.answers.getAnswers().size(); i2++) {
                    if (this.answers.getAnswers().get(i2).toString().equalsIgnoreCase("1")) {
                        if (i2 == 0) {
                            boolean zEqualsIgnoreCase = this.result.getIsCorrect().equalsIgnoreCase("0");
                            str = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                            if (zEqualsIgnoreCase) {
                                this.parentList.get(i2).setBackground(getResources().getDrawable(R.drawable.bg_mcq_selected4));
                                TextView textView = (TextView) ((LinearLayout) this.parentList.get(i2)).getChildAt(1);
                                textView.setBackgroundResource(R.drawable.circle4);
                                textView.setTextColor(getResources().getColor(R.color.white));
                                str5 = "Incorrect";
                                str2 = str;
                            } else {
                                if (this.result.getIsCorrect().equalsIgnoreCase("1")) {
                                    this.LinearLayoutList.get(i2).setSelected(true);
                                    str5 = "Correct";
                                }
                                str2 = str;
                            }
                        } else if (i2 == 1) {
                            str = "B";
                            if (this.result.getIsCorrect().equalsIgnoreCase("0")) {
                                this.parentList.get(i2).setBackground(getResources().getDrawable(R.drawable.bg_mcq_selected4));
                                TextView textView2 = (TextView) ((LinearLayout) this.parentList.get(i2)).getChildAt(1);
                                textView2.setBackgroundResource(R.drawable.circle4);
                                textView2.setTextColor(getResources().getColor(R.color.white));
                                str5 = "Incorrect";
                                str2 = str;
                            } else {
                                if (this.result.getIsCorrect().equalsIgnoreCase("1")) {
                                    this.LinearLayoutList.get(i2).setSelected(true);
                                    str5 = "Correct";
                                }
                                str2 = str;
                            }
                        } else if (i2 == 2) {
                            str = "C";
                            if (this.result.getIsCorrect().equalsIgnoreCase("0")) {
                                this.parentList.get(i2).setBackground(getResources().getDrawable(R.drawable.bg_mcq_selected4));
                                TextView textView3 = (TextView) ((LinearLayout) this.parentList.get(i2)).getChildAt(1);
                                textView3.setBackgroundResource(R.drawable.circle4);
                                textView3.setTextColor(getResources().getColor(R.color.white));
                                str5 = "Incorrect";
                                str2 = str;
                            } else {
                                if (this.result.getIsCorrect().equalsIgnoreCase("1")) {
                                    this.LinearLayoutList.get(i2).setSelected(true);
                                    str5 = "Correct";
                                }
                                str2 = str;
                            }
                        } else if (i2 == 3) {
                            str = "D";
                            if (this.result.getIsCorrect().equalsIgnoreCase("0")) {
                                this.parentList.get(i2).setBackground(getResources().getDrawable(R.drawable.bg_mcq_selected4));
                                TextView textView4 = (TextView) ((LinearLayout) this.parentList.get(i2)).getChildAt(1);
                                textView4.setBackgroundResource(R.drawable.circle4);
                                textView4.setTextColor(getResources().getColor(R.color.white));
                                str5 = "Incorrect";
                                str2 = str;
                            } else {
                                if (this.result.getIsCorrect().equalsIgnoreCase("1")) {
                                    this.LinearLayoutList.get(i2).setSelected(true);
                                    str5 = "Correct";
                                }
                                str2 = str;
                            }
                        }
                    }
                }
                this.question_status.setVisibility(0);
                this.your_ans_text.setText(str2);
                this.question_status.setText("|| " + str5);
            } else if (this.answers.getAnswers().equals("not_visited")) {
                this.your_ans_text.setText(this.activity.getResources().getString(R.string.not_visited));
            } else {
                this.your_ans_text.setText(this.answers.getState());
            }
            if (this.questionDump.getOption1() != null && this.questionDump.getOption1().equalsIgnoreCase(this.questionDump.getRight_answer())) {
                this.LinearLayoutList.get(0).setSelected(true);
                return;
            }
            if (this.questionDump.getOption2() != null && this.questionDump.getOption2().equalsIgnoreCase(this.questionDump.getRight_answer())) {
                this.LinearLayoutList.get(1).setSelected(true);
                return;
            }
            if (this.questionDump.getOption3() != null && this.questionDump.getOption3().equalsIgnoreCase(this.questionDump.getRight_answer())) {
                this.LinearLayoutList.get(2).setSelected(true);
            } else {
                if (this.questionDump.getOption4() == null || !this.questionDump.getOption4().equalsIgnoreCase(this.questionDump.getRight_answer())) {
                    return;
                }
                this.LinearLayoutList.get(3).setSelected(true);
            }
        }
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
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.result.getOption4() == null || this.result.getOption4().isEmpty()) {
                                this.status = true;
                            } else {
                                this.mcqoptionsLL.addView(initMCQOptionView("D", this.result.getOption4(), "11", false, i - 1));
                            }
                        }
                    } else if (this.result.getOption3() == null || this.result.getOption3().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("C", this.result.getOption3(), "11", false, i - 1));
                    }
                } else if (this.result.getOption2().isEmpty()) {
                    this.status = true;
                } else {
                    this.mcqoptionsLL.addView(initMCQOptionView("B", this.result.getOption2(), "11", false, i - 1));
                }
            } else if (this.result.getOption1().isEmpty()) {
                this.status = true;
            } else {
                this.mcqoptionsLL.addView(initMCQOptionView(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, this.result.getOption1(), "11", false, i - 1));
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
                this.mDrawable.setBounds(0, 0, ViewSolutuionRevisionFragment.this.empty.getIntrinsicWidth(), ViewSolutuionRevisionFragment.this.empty.getIntrinsicHeight());
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
