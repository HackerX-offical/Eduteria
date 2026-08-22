package com.appnew.android.CreateTest.Fragment;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.CreateTest.Activity.TestCreateActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Progress;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.adapter.FIB_Adapter;
import com.appnew.android.testmodule.model.FIBEdit;
import com.appnew.android.testmodule.model.Question;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.variables.CTVariableUtils;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class FIB_CreateTestSeriesFragment extends MainFragment implements View.OnClickListener, Html.ImageGetter {
    LinearLayout LLFIBquestion;
    List<View> LinearLayoutList;
    private Drawable empty;
    LinearLayout explanationLL;
    TextView explanationTV;
    FIB_Adapter fib_adapter;
    private String guess;
    private ImageView imgBookmark;
    private String isCorrect;
    Progress mProgress;
    LinearLayout mcqoptionsLL;
    NestedScrollView nestedSV;
    private NetworkCall networkCall;
    LinearLayout parentLL;
    List<View> parentList;
    int position;
    private Question questionBank;
    RelativeLayout question_layout1;
    RecyclerView rvfibquestion;
    private boolean status;
    List<TextView> tvList;
    List<TextView> tvQuesList;
    ClickableWebView tvQuestion;
    ClickableWebView tvQuestionFib;
    int count = 0;
    List<FIBEdit> fibEdits = new ArrayList();
    int selectedAnswerposition = -1;
    ArrayList<Integer> selectedValue = new ArrayList<>();
    ArrayList<String> selectedValue1 = new ArrayList<>();
    ArrayList<TextView> textViews = new ArrayList<>();
    ArrayList tags = new ArrayList();
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.FIB_CreateTestSeriesFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FIB_CreateTestSeriesFragment.this.selectedAnswerposition = ((Integer) view.getTag()).intValue();
            if (FIB_CreateTestSeriesFragment.this.LinearLayoutList.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).isSelected()) {
                int i = 0;
                while (true) {
                    if (i >= FIB_CreateTestSeriesFragment.this.selectedValue.size()) {
                        break;
                    }
                    if (FIB_CreateTestSeriesFragment.this.selectedAnswerposition == FIB_CreateTestSeriesFragment.this.selectedValue.get(i).intValue()) {
                        FIB_CreateTestSeriesFragment.this.selectedValue.remove(i);
                        FIB_CreateTestSeriesFragment.this.selectedValue1.remove(i);
                        String type = FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getType();
                        type.hashCode();
                        if (type.equals(CTVariableUtils.NUMBER)) {
                            FIB_CreateTestSeriesFragment fIB_CreateTestSeriesFragment = FIB_CreateTestSeriesFragment.this;
                            fIB_CreateTestSeriesFragment.showEnterData(fIB_CreateTestSeriesFragment.textViews.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition), FIB_CreateTestSeriesFragment.this.textViews.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getText().toString(), FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getType(), "", "");
                        } else {
                            FIB_CreateTestSeriesFragment fIB_CreateTestSeriesFragment2 = FIB_CreateTestSeriesFragment.this;
                            fIB_CreateTestSeriesFragment2.showEnterData(fIB_CreateTestSeriesFragment2.textViews.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition), FIB_CreateTestSeriesFragment.this.textViews.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getText().toString(), FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getType(), FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getMax(), FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getMin());
                        }
                    } else {
                        i++;
                    }
                }
            } else {
                String type2 = FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getType();
                type2.hashCode();
                if (type2.equals(CTVariableUtils.NUMBER)) {
                    FIB_CreateTestSeriesFragment fIB_CreateTestSeriesFragment3 = FIB_CreateTestSeriesFragment.this;
                    fIB_CreateTestSeriesFragment3.showEnterData(fIB_CreateTestSeriesFragment3.textViews.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition), "", FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getType(), "", "");
                } else {
                    FIB_CreateTestSeriesFragment fIB_CreateTestSeriesFragment4 = FIB_CreateTestSeriesFragment.this;
                    fIB_CreateTestSeriesFragment4.showEnterData(fIB_CreateTestSeriesFragment4.textViews.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition), "", FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getType(), FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getMax(), FIB_CreateTestSeriesFragment.this.fibEdits.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).getMin());
                }
            }
            for (int i2 = 0; i2 < FIB_CreateTestSeriesFragment.this.LinearLayoutList.size(); i2++) {
                if (FIB_CreateTestSeriesFragment.this.LinearLayoutList.get(i2).isSelected()) {
                    String str = "";
                    for (int i3 = 0; i3 < ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).getSelectedValue().size(); i3++) {
                        str = str + ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).getSelectedValue().get(i3) + Constants.SEPARATOR_COMMA;
                    }
                    FIB_CreateTestSeriesFragment.this.tags.clear();
                    for (int i4 = 0; i4 < FIB_CreateTestSeriesFragment.this.LinearLayoutList.size(); i4++) {
                        if (str.contains(String.valueOf(i4))) {
                            FIB_CreateTestSeriesFragment.this.tags.add("1");
                        } else {
                            FIB_CreateTestSeriesFragment.this.tags.add("0");
                        }
                    }
                    ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).setIsanswer(true, FIB_CreateTestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_CreateTestSeriesFragment.this.selectedValue1);
                    return;
                }
            }
            ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).setIsanswer(false, 0);
        }
    };

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

    public static FIB_CreateTestSeriesFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.POSITION, position);
        FIB_CreateTestSeriesFragment fIB_CreateTestSeriesFragment = new FIB_CreateTestSeriesFragment();
        fIB_CreateTestSeriesFragment.setArguments(bundle);
        return fIB_CreateTestSeriesFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_series_create, (ViewGroup) null);
        this.activity = this.activity;
        getBundleData();
        initView(viewInflate);
        this.mProgress = new Progress(this.activity);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEnterData(final TextView textView, String messege, String type, String max, String min) {
        View viewInflate = ((LayoutInflater) this.activity.getSystemService("layout_inflater")).inflate(R.layout.enter_fib_layout, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this.activity);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(viewInflate);
        dialog.show();
        Button button = (Button) viewInflate.findViewById(R.id.btn_submit);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.message);
        if (type.equalsIgnoreCase(CTVariableUtils.NUMBER)) {
            editText.setInputType(12290);
        } else {
            editText.setInputType(1);
        }
        if (!min.equalsIgnoreCase("")) {
            editText.setMinLines(Integer.parseInt(min));
        }
        if (!max.equalsIgnoreCase("")) {
            editText.setMaxLines(Integer.parseInt(max));
        }
        if (!messege.equalsIgnoreCase("")) {
            editText.setText(messege);
        } else {
            editText.setHint("Enter Answer");
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.FIB_CreateTestSeriesFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(FIB_CreateTestSeriesFragment.this.activity, FIB_CreateTestSeriesFragment.this.activity.getResources().getString(R.string.please_enter_answer), 0).show();
                    return;
                }
                dialog.dismiss();
                if (!TextUtils.isEmpty(editText.getText())) {
                    textView.setText(editText.getText().toString());
                    FIB_CreateTestSeriesFragment.this.LinearLayoutList.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).setSelected(true);
                    FIB_CreateTestSeriesFragment.this.selectedValue.add(FIB_CreateTestSeriesFragment.this.selectedAnswerposition, Integer.valueOf(FIB_CreateTestSeriesFragment.this.selectedAnswerposition));
                    FIB_CreateTestSeriesFragment.this.selectedValue1.add(FIB_CreateTestSeriesFragment.this.selectedAnswerposition, editText.getText().toString());
                    if (FIB_CreateTestSeriesFragment.this.selectedValue1.size() > 0 && FIB_CreateTestSeriesFragment.this.selectedValue1.size() == 3) {
                        if (FIB_CreateTestSeriesFragment.this.selectedValue1.get(2).equalsIgnoreCase("")) {
                            FIB_CreateTestSeriesFragment.this.selectedValue1.remove(2);
                            FIB_CreateTestSeriesFragment.this.selectedValue.remove(2);
                        } else if (FIB_CreateTestSeriesFragment.this.selectedValue1.get(1).equalsIgnoreCase("")) {
                            FIB_CreateTestSeriesFragment.this.selectedValue1.remove(1);
                            FIB_CreateTestSeriesFragment.this.selectedValue.remove(1);
                        }
                    }
                    ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).setSelectedValue(FIB_CreateTestSeriesFragment.this.selectedValue);
                    ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).setSelectedString(FIB_CreateTestSeriesFragment.this.selectedValue1);
                    if (((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).changelang.getText().equals("H/E")) {
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).data.getQuestionsHindi().get(FIB_CreateTestSeriesFragment.this.position).setSelectedValue(FIB_CreateTestSeriesFragment.this.selectedValue);
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).data.getQuestionsHindi().get(FIB_CreateTestSeriesFragment.this.position).setSelectedString(FIB_CreateTestSeriesFragment.this.selectedValue1);
                    } else if (((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).changelang.getText().equals("E/H")) {
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).data.getQuestions().get(FIB_CreateTestSeriesFragment.this.position).setSelectedValue(FIB_CreateTestSeriesFragment.this.selectedValue);
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).data.getQuestions().get(FIB_CreateTestSeriesFragment.this.position).setSelectedString(FIB_CreateTestSeriesFragment.this.selectedValue1);
                    }
                } else {
                    textView.setText(FIB_CreateTestSeriesFragment.this.activity.getResources().getString(R.string.enter_answer));
                    FIB_CreateTestSeriesFragment.this.LinearLayoutList.get(FIB_CreateTestSeriesFragment.this.selectedAnswerposition).setSelected(false);
                    ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).setSelectedString(FIB_CreateTestSeriesFragment.this.selectedValue1);
                    ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).setSelectedValue(FIB_CreateTestSeriesFragment.this.selectedValue);
                    if (((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).changelang.getText().equals("H/E")) {
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).data.getQuestionsHindi().get(FIB_CreateTestSeriesFragment.this.position).setSelectedValue(FIB_CreateTestSeriesFragment.this.selectedValue);
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).data.getQuestionsHindi().get(FIB_CreateTestSeriesFragment.this.position).setSelectedString(FIB_CreateTestSeriesFragment.this.selectedValue1);
                    } else if (((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).changelang.getText().equals("E/H")) {
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).data.getQuestions().get(FIB_CreateTestSeriesFragment.this.position).setSelectedValue(FIB_CreateTestSeriesFragment.this.selectedValue);
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).data.getQuestions().get(FIB_CreateTestSeriesFragment.this.position).setSelectedString(FIB_CreateTestSeriesFragment.this.selectedValue1);
                    }
                }
                for (int i = 0; i < FIB_CreateTestSeriesFragment.this.LinearLayoutList.size(); i++) {
                    if (FIB_CreateTestSeriesFragment.this.LinearLayoutList.get(i).isSelected()) {
                        String str = "";
                        for (int i2 = 0; i2 < ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).getSelectedValue().size(); i2++) {
                            str = str + ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).getSelectedValue().get(i2) + Constants.SEPARATOR_COMMA;
                        }
                        if (str.startsWith("1")) {
                            str = "0," + str;
                            FIB_CreateTestSeriesFragment.this.selectedValue1.add(0, "");
                        }
                        ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).setIsanswer(true, FIB_CreateTestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_CreateTestSeriesFragment.this.selectedValue1);
                        if (((TestCreateActivity) FIB_CreateTestSeriesFragment.this.getActivity()).changelang.getText().equals("H/E")) {
                            ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.getActivity()).data.getQuestionsHindi().get(FIB_CreateTestSeriesFragment.this.position).setIsanswer(true, FIB_CreateTestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_CreateTestSeriesFragment.this.selectedValue1);
                            return;
                        } else {
                            if (((TestCreateActivity) FIB_CreateTestSeriesFragment.this.getActivity()).changelang.getText().equals("E/H")) {
                                ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.getActivity()).data.getQuestions().get(FIB_CreateTestSeriesFragment.this.position).setIsanswer(true, FIB_CreateTestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_CreateTestSeriesFragment.this.selectedValue1);
                                return;
                            }
                            return;
                        }
                    }
                }
                ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.activity).questionBankList.get(FIB_CreateTestSeriesFragment.this.position).setIsanswer(false, 0);
                if (((TestCreateActivity) FIB_CreateTestSeriesFragment.this.getActivity()).changelang.getText().equals("H/E")) {
                    ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.getActivity()).data.getQuestionsHindi().get(FIB_CreateTestSeriesFragment.this.position).setIsanswer(false, 0);
                } else if (((TestCreateActivity) FIB_CreateTestSeriesFragment.this.getActivity()).changelang.getText().equals("E/H")) {
                    ((TestCreateActivity) FIB_CreateTestSeriesFragment.this.getActivity()).data.getQuestions().get(FIB_CreateTestSeriesFragment.this.position).setIsanswer(false, 0);
                }
            }
        });
    }

    private void getBundleData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.position = arguments.getInt(Const.POSITION, 0);
        }
    }

    public void refereshPage() {
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            ((TestCreateActivity) this.activity).questionBankList.get(this.position).getSelectedValue().clear();
            ((TestCreateActivity) this.activity).questionBankList.get(this.position).getSelectedString().clear();
            this.guess = "0";
            this.selectedValue.clear();
            this.selectedValue1.clear();
            for (int i = 0; i < this.LinearLayoutList.size(); i++) {
                this.LinearLayoutList.get(i).setSelected(false);
                this.tvQuesList.get(i).setText(this.activity.getResources().getString(R.string.enter_answer_) + ((Object) this.tvList.get(i).getText()) + " )");
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            this.guess = "0";
            for (int i2 = 0; i2 < this.LinearLayoutList.size(); i2++) {
                this.LinearLayoutList.get(i2).setSelected(false);
            }
            ((TestCreateActivity) this.activity).questionBankList.get(this.position).setIsanswer(false, 0);
            if (((TestCreateActivity) Objects.requireNonNull(this.activity)).changelang.getText().equals("H/E")) {
                ((TestCreateActivity) this.activity).data.getQuestionsHindi().get(this.position).setIsanswer(false, 0);
            } else if (((TestCreateActivity) this.activity).changelang.getText().equals("E/H")) {
                ((TestCreateActivity) this.activity).data.getQuestions().get(this.position).setIsanswer(false, 0);
            }
            if (((TestCreateActivity) this.activity).changelang.getText().equals("H/E") && ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestionsHindi() != null && ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestionsHindi().size() > 0) {
                ((TestBaseActivity) Objects.requireNonNull(getActivity())).questionBankList.get(this.position).setAnspositions("-1");
                ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestionsHindi().get(this.position).setSelectedValue(arrayList2);
                ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestionsHindi().get(this.position).setSelectedString(arrayList3);
                ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestionsHindi().get(this.position).setAnswers(arrayList);
            }
            if (((TestCreateActivity) this.activity).changelang.getText().equals("E/H") && ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestions() != null && ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestions().size() > 0) {
                ((TestBaseActivity) Objects.requireNonNull(getActivity())).questionBankList.get(this.position).setAnspositions("-1");
                ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestions().get(this.position).setSelectedValue(arrayList2);
                ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestions().get(this.position).setSelectedString(arrayList3);
                ((TestCreateActivity) Objects.requireNonNull(this.activity)).data.getQuestions().get(this.position).setAnswers(arrayList);
            }
            ((TestCreateActivity) Objects.requireNonNull(this.activity)).questionBankList.get(this.position).setSelectedValue(arrayList2);
            ((TestBaseActivity) Objects.requireNonNull(getActivity())).questionBankList.get(this.position).setAnspositions("-1");
            ((TestCreateActivity) Objects.requireNonNull(this.activity)).questionBankList.get(this.position).setSelectedString(arrayList3);
            ((TestCreateActivity) Objects.requireNonNull(this.activity)).questionBankList.get(this.position).setSelectedValue(arrayList2);
            ((TestCreateActivity) Objects.requireNonNull(this.activity)).questionBankList.get(this.position).setAnswers(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private void initView(View view) {
        this.mcqoptionsLL = (LinearLayout) view.findViewById(R.id.mcqoptions);
        this.tvQuestion = (ClickableWebView) view.findViewById(R.id.tv_question);
        this.question_layout1 = (RelativeLayout) view.findViewById(R.id.question_layout1);
        this.tvQuestionFib = (ClickableWebView) view.findViewById(R.id.tv_question_fib);
        this.imgBookmark = (ImageView) view.findViewById(R.id.img_bookmark);
        this.LLFIBquestion = (LinearLayout) view.findViewById(R.id.LLFIBquestion);
        this.rvfibquestion = (RecyclerView) view.findViewById(R.id.rvfibquestion1);
        this.explanationLL = (LinearLayout) view.findViewById(R.id.explanationLL);
        this.explanationTV = (TextView) view.findViewById(R.id.explanationTV);
        this.nestedSV = (NestedScrollView) view.findViewById(R.id.nestedSV);
        this.LinearLayoutList = new ArrayList();
        this.parentList = new ArrayList();
        this.tvList = new ArrayList();
        this.tvQuesList = new ArrayList();
        this.questionBank = ((TestCreateActivity) this.activity).questionBankList.get(this.position);
        String question = ((TestCreateActivity) this.activity).questionBankList.get(this.position).getQuestion();
        this.mcqoptionsLL.setVisibility(0);
        this.LLFIBquestion.setVisibility(8);
        String strReplace = question.replace("FIB", ".....");
        this.tvQuestion.setBackgroundColor(0);
        this.tvQuestion.setLayerType(2, null);
        this.tvQuestion.getSettings().setJavaScriptEnabled(true);
        this.tvQuestion.getSettings().setGeolocationEnabled(true);
        Helper.TestWebHTMLLoad(this.tvQuestion, "Q-" + (this.position + 1) + ". " + strReplace);
        this.tvQuestion.setLongClickable(false);
        this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.question_layout1));
        if (TextUtils.isEmpty(((TestCreateActivity) this.activity).questionBankList.get(this.position).getParagraphText())) {
            this.tvQuestionFib.setVisibility(8);
        } else {
            this.tvQuestionFib.setVisibility(0);
            Helper.TestWebHTMLLoad(this.tvQuestionFib, ((TestCreateActivity) this.activity).questionBankList.get(this.position).getParagraphText());
        }
        addQuestionOption();
        this.imgBookmark.setOnClickListener(this);
        if (((TestCreateActivity) this.activity).questionBankList.get(this.position).getIs_bookmarked().equals("1")) {
            this.imgBookmark.setImageResource(R.mipmap.bookmark_selected);
        } else {
            this.imgBookmark.setImageResource(R.mipmap.bookmark_unselected);
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

    private void addQuestionOption() {
        ArrayList<TextView> arrayList = this.textViews;
        if (arrayList != null) {
            arrayList.clear();
        }
        for (int i = 1; i <= countFIBWords(this.questionBank.getQuestion().trim()) && !this.status; i++) {
            switch (i) {
                case 1:
                    if (this.questionBank.getOption1().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("1", this.questionBank.getOption1(), "11", false, i - 1));
                        continue;
                    }
                    break;
                case 2:
                    if (this.questionBank.getOption2().isEmpty()) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("2", this.questionBank.getOption2(), "11", false, i - 1));
                    }
                    break;
                case 3:
                    if (this.questionBank.getOption3().isEmpty()) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("3", this.questionBank.getOption3(), "11", false, i - 1));
                    }
                    break;
                case 4:
                    if (this.questionBank.getOption4().isEmpty()) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("4", this.questionBank.getOption4(), "11", false, i - 1));
                    }
                    break;
                case 5:
                    if (this.questionBank.getOption5().isEmpty()) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("5", this.questionBank.getOption5(), "11", false, i - 1));
                    }
                    break;
                case 6:
                    if (this.questionBank.getOption6().isEmpty()) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("6", this.questionBank.getOption6(), "11", false, i - 1));
                    }
                    break;
                case 7:
                    if (this.questionBank.getOption7().isEmpty()) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("7", this.questionBank.getOption7(), "11", false, i - 1));
                    }
                    break;
                case 8:
                    if (this.questionBank.getOption8().isEmpty()) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("8", this.questionBank.getOption8(), "11", false, i - 1));
                    }
                    break;
                case 9:
                    if (this.questionBank.getOption9().isEmpty()) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("9", this.questionBank.getOption9(), "11", false, i - 1));
                    }
                    break;
                case 10:
                    if (this.questionBank.getOption10().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("10", this.questionBank.getOption10(), "11", false, i - 1));
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
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.layout_option_test_view_fib, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.optionIconTV);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.optionTextTV);
        textView2.setAllCaps(false);
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
        FIBEdit fIBEdit = (FIBEdit) new Gson().fromJson(str2, FIBEdit.class);
        if (fIBEdit != null && !fIBEdit.getType().equalsIgnoreCase("")) {
            this.fibEdits.add(fIBEdit);
        }
        this.textViews.add(textView2);
        linearLayout.setTag(Integer.valueOf(i));
        if (((TestCreateActivity) this.activity).questionBankList.get(this.position).getSelectedValue() != null) {
            if (((TestCreateActivity) this.activity).questionBankList.get(this.position).getSelectedValue().contains(Integer.valueOf(i))) {
                if (TextUtils.isEmpty(((TestCreateActivity) this.activity).questionBankList.get(this.position).getSelectedString().get(i))) {
                    this.selectedValue1.add("");
                    textView2.setText(this.activity.getResources().getString(R.string.enter_answer_) + str + " )");
                } else {
                    linearLayout.setSelected(true);
                    textView2.setText(((TestCreateActivity) this.activity).questionBankList.get(this.position).getSelectedString().get(i));
                    this.selectedValue1.add(((TestCreateActivity) this.activity).questionBankList.get(this.position).getSelectedString().get(i));
                    this.selectedValue = ((TestCreateActivity) this.activity).questionBankList.get(this.position).getSelectedValue();
                }
            } else {
                textView2.setText(this.activity.getResources().getString(R.string.enter_answer_) + str + " )");
                this.selectedValue.add(0);
                this.selectedValue1.add("");
            }
        }
        this.LinearLayoutList.add(linearLayout);
        this.parentList.add(this.parentLL);
        this.tvList.add(textView);
        this.tvQuesList.add(textView2);
        linearLayout.setOnClickListener(this.onClickListener);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.img_bookmark) {
            return;
        }
        if (((TestCreateActivity) this.activity).questionBankList.get(this.position).getIs_bookmarked().equals("1")) {
            ((TestCreateActivity) this.activity).questionBankList.get(this.position).setIs_bookmarked("0");
            this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_unselected));
            Toast.makeText(this.activity, this.activity.getResources().getString(R.string.unboomark), 0).show();
        } else {
            ((TestCreateActivity) this.activity).questionBankList.get(this.position).setIs_bookmarked("1");
            this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_selected));
            Toast.makeText(this.activity, this.activity.getResources().getString(R.string.boomark), 0).show();
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
                this.mDrawable.setBounds(0, 0, FIB_CreateTestSeriesFragment.this.empty.getIntrinsicWidth(), FIB_CreateTestSeriesFragment.this.empty.getIntrinsicHeight());
                this.mDrawable.setLevel(1);
            }
        }
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
}
