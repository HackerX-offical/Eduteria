package com.appnew.android.testmodule.fragment;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.adapter.AdapterMatchingListDrag;
import com.appnew.android.testmodule.adapter.AdapterMatchingListNormal;
import com.appnew.android.testmodule.interfaces.MachingOnDrag;
import com.appnew.android.testmodule.mathview.MathView;
import com.appnew.android.testmodule.model.Social;
import com.appnew.android.testmodule.model.mcSelection;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class SC_TestSeriesFragment extends MainFragment implements View.OnClickListener, Html.ImageGetter, MachingOnDrag, NetworkCall.MyNetworkCallBack {
    public static final String HTML_ENTITY = "&[a-zA-Z][a-zA-Z0-9]+;";
    public static final String TAG_END = "</\\w+>";
    public static final String TAG_SELF_CLOSING = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>";
    public static final String TAG_START = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>";
    public static final Pattern htmlPattern = Pattern.compile("(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>.*</\\w+>)|(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>)|(&[a-zA-Z][a-zA-Z0-9]+;)", 32);
    LinearLayout LLmatchinquestion;
    List<View> LinearLayoutList;
    private AdapterMatchingListDrag adapterMatchingListDrag;
    private AdapterMatchingListNormal adapterMatchingListNormal;
    private CheckBox checkBoxGuess;
    private Drawable empty;
    LinearLayout explanationLL;
    TextView explanationTV;
    private String guess;
    private ImageView imgBookmark;
    private String isCorrect;
    private LinearLayout llTimerNegPos;
    Progress mProgress;
    private TextView mandatoryType;
    private TextView markForReview;
    LinearLayout mcqoptionsLL;
    private TextView multiple_choice_instruction;
    private TextView neg_mark;
    NestedScrollView nestedSV;
    private NetworkCall networkCall;
    LinearLayout parentLL;
    List<View> parentList;
    View parent_view;
    private TextView pos_mark;
    int position;
    String questionId;
    String questionType;
    RelativeLayout question_layout1;
    private TextView remove_mark_for_review;
    RecyclerView rvmatchinquestion1;
    RecyclerView rvmatchinquestion2;
    private TextView save_mark_for_review;
    int selectedAnswerposition;
    private boolean status;
    private boolean status1;
    private TextView tvEmail;
    List<View> tvList;
    ClickableWebView tvQuestion;
    ClickableWebView tvQuestionFib;
    private TextView tvReportError;
    private TextView tv_timer;
    private TextView tv_uid;
    private TextView unmarkForReview;
    int count = 0;
    ArrayList<Integer> selectedValue = new ArrayList<>();
    ArrayList<mcSelection> selected = new ArrayList<>();
    ArrayList<mcSelection> selected2 = new ArrayList<>();
    ArrayList tags = new ArrayList();
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.SC_TestSeriesFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((TestBaseActivity) SC_TestSeriesFragment.this.activity).isOptionCountExceed(SC_TestSeriesFragment.this.position)) {
                Toast.makeText(SC_TestSeriesFragment.this.activity, "You can attempt only " + ((TestBaseActivity) SC_TestSeriesFragment.this.activity).getSectionOptionalCount(SC_TestSeriesFragment.this.position) + " optional questions", 0).show();
                return;
            }
            if (!((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).isIssaveMarkForReview()) {
                String str = SC_TestSeriesFragment.this.questionType;
                str.hashCode();
                switch (str) {
                    case "MC":
                        SC_TestSeriesFragment.this.MC_Clicked(view);
                        break;
                    case "MT":
                    case "FIB":
                        break;
                    case "PG":
                        if (!TextUtils.isEmpty(((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getAnswer()) && ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getAnswer().contains(Constants.SEPARATOR_COMMA)) {
                            SC_TestSeriesFragment.this.MC_Clicked(view);
                            break;
                        } else {
                            SC_TestSeriesFragment.this.SC_Clicked(view);
                            break;
                        }
                        break;
                    case "SC":
                        SC_TestSeriesFragment.this.SC_Clicked(view);
                        break;
                    case "TF":
                        SC_TestSeriesFragment.this.SC_Clicked(view);
                        break;
                    default:
                        SC_TestSeriesFragment.this.SC_Clicked(view);
                        break;
                }
                return;
            }
            Toast.makeText(SC_TestSeriesFragment.this.activity, SC_TestSeriesFragment.this.activity.getResources().getString(R.string.select_remove_and_mark_for_review), 0).show();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void SC_Clicked(View view) {
        this.selectedAnswerposition = ((Integer) view.getTag()).intValue();
        int size = this.LinearLayoutList.size();
        ArrayList arrayList = this.tags;
        if (arrayList != null) {
            arrayList.clear();
        }
        if ((!((TestBaseActivity) requireActivity()).questionBankList.get(this.position).isanswer() && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() == 0) || ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() == -1) {
            for (int i = 0; i < this.LinearLayoutList.size(); i++) {
                if (this.selectedAnswerposition == i) {
                    this.tags.add(i, "1");
                } else {
                    this.tags.add("0");
                }
            }
            ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
            if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
                ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
            }
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
            } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
            }
        } else if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).isanswer() && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() != 0 && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() != -1) {
            if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() == this.selectedAnswerposition + 1) {
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIsanswer(false, 0, this.tags);
                if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
                    ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setIsanswer(false, 0, this.tags);
                }
                if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIsanswer(false, 0);
                } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsanswer(false, 0);
                }
            } else {
                for (int i2 = 0; i2 < this.LinearLayoutList.size(); i2++) {
                    if (this.selectedAnswerposition == i2) {
                        this.tags.add(i2, "1");
                    } else {
                        this.tags.add("0");
                    }
                }
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
                if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
                    ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
                }
                if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
                } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
                }
            }
        }
        this.explanationLL.setVisibility(8);
        for (int i3 = 0; i3 < size; i3++) {
            if (this.selectedAnswerposition == i3) {
                if (this.LinearLayoutList.get(i3).isSelected()) {
                    this.LinearLayoutList.get(i3).setSelected(false);
                } else {
                    this.LinearLayoutList.get(i3).setSelected(true);
                }
            } else {
                this.LinearLayoutList.get(i3).setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MC_Clicked(View view) {
        this.selectedAnswerposition = ((Integer) view.getTag()).intValue();
        ((TestBaseActivity) this.activity).questionBankList.get(this.position).getAnswer().split(Constants.SEPARATOR_COMMA);
        if (this.LinearLayoutList.get(this.selectedAnswerposition).isSelected()) {
            int i = 0;
            while (true) {
                if (i >= this.selectedValue.size()) {
                    break;
                }
                if (this.selectedAnswerposition == this.selectedValue.get(i).intValue()) {
                    this.LinearLayoutList.get(this.selectedAnswerposition).setSelected(false);
                    this.selectedValue.remove(i);
                    break;
                }
                i++;
            }
            ((TestBaseActivity) this.activity).questionBankList.get(this.position).setSelectedValue(this.selectedValue);
            if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
                ((TestBaseActivity) this.activity).questionBankList2.get(this.position).setSelectedValue(this.selectedValue);
            }
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                ((TestBaseActivity) this.activity).data.getQuestionsHindi().get(this.position).setSelectedValue(this.selectedValue);
            } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setSelectedValue(this.selectedValue);
            }
        } else {
            this.LinearLayoutList.get(this.selectedAnswerposition).setSelected(true);
            if (!this.selectedValue.contains(Integer.valueOf(this.selectedAnswerposition))) {
                this.selectedValue.add(Integer.valueOf(this.selectedAnswerposition));
            }
            ((TestBaseActivity) this.activity).questionBankList.get(this.position).setSelectedValue(this.selectedValue);
            if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
                ((TestBaseActivity) this.activity).questionBankList2.get(this.position).setSelectedValue(this.selectedValue);
            }
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                ((TestBaseActivity) this.activity).data.getQuestionsHindi().get(this.position).setSelectedValue(this.selectedValue);
            } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setSelectedValue(this.selectedValue);
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.LinearLayoutList.size(); i2++) {
            if (this.LinearLayoutList.get(i2).isSelected()) {
                z = true;
            }
        }
        if (z) {
            String str = "";
            for (int i3 = 0; i3 < ((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedValue().size(); i3++) {
                str = str + ((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedValue().get(i3) + Constants.SEPARATOR_COMMA;
            }
            this.tags.clear();
            for (int i4 = 0; i4 < this.LinearLayoutList.size(); i4++) {
                if (str.contains(String.valueOf(i4))) {
                    this.tags.add("1");
                } else {
                    this.tags.add("0");
                }
            }
            ((TestBaseActivity) this.activity).questionBankList.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, str, this.tags);
            if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
                ((TestBaseActivity) this.activity).questionBankList2.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, str, this.tags);
            }
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                ((TestBaseActivity) this.activity).data.getQuestionsHindi().get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, str, this.tags);
                return;
            } else {
                if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, str, this.tags);
                    return;
                }
                return;
            }
        }
        ((TestBaseActivity) this.activity).questionBankList.get(this.position).setIsanswer(false, 0);
        if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
            ((TestBaseActivity) this.activity).questionBankList2.get(this.position).setIsanswer(false, 0);
        }
        if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
            ((TestBaseActivity) this.activity).data.getQuestionsHindi().get(this.position).setIsanswer(false, 0);
        } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
            ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsanswer(false, 0);
        }
    }

    public static SC_TestSeriesFragment newInstance(int position, String questionType) {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.POSITION, position);
        bundle.putString("questionType", questionType);
        SC_TestSeriesFragment sC_TestSeriesFragment = new SC_TestSeriesFragment();
        sC_TestSeriesFragment.setArguments(bundle);
        return sC_TestSeriesFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_series, (ViewGroup) null);
        this.activity = requireActivity();
        this.networkCall = new NetworkCall(this, this.activity);
        getBundleData();
        initView(viewInflate);
        this.mProgress = new Progress(this.activity);
        return viewInflate;
    }

    private void getBundleData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.position = arguments.getInt(Const.POSITION, 0);
            this.questionType = arguments.getString("questionType", "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") == null || TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            return;
        }
        changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
    }

    public void changeThemeColor(String color) {
        if (!color.contains(":") || color.split(":").length <= 1) {
            return;
        }
        SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
        this.markForReview.setTextColor(Color.parseColor(color.split(":")[1]));
        this.markForReview.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color.split(":")[0])));
    }

    private void initView(View view) {
        this.mcqoptionsLL = (LinearLayout) view.findViewById(R.id.mcqoptions);
        this.LLmatchinquestion = (LinearLayout) view.findViewById(R.id.LLmatchinquestion);
        this.rvmatchinquestion1 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion1);
        this.rvmatchinquestion2 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion2);
        this.rvmatchinquestion1.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setHasFixedSize(true);
        this.tvQuestion = (ClickableWebView) view.findViewById(R.id.tv_question);
        this.question_layout1 = (RelativeLayout) view.findViewById(R.id.question_layout1);
        this.imgBookmark = (ImageView) view.findViewById(R.id.img_bookmark);
        this.checkBoxGuess = (CheckBox) view.findViewById(R.id.checkBox);
        this.markForReview = (TextView) view.findViewById(R.id.mark_for_review);
        this.tvQuestionFib = (ClickableWebView) view.findViewById(R.id.tv_question_fib);
        this.save_mark_for_review = (TextView) view.findViewById(R.id.save_mark_for_review);
        this.remove_mark_for_review = (TextView) view.findViewById(R.id.remove_mark_for_review);
        this.unmarkForReview = (TextView) view.findViewById(R.id.unmark_for_review);
        this.tvReportError = (TextView) view.findViewById(R.id.tv_report_error);
        this.tv_uid = (TextView) view.findViewById(R.id.tv_uid);
        this.tvEmail = (TextView) view.findViewById(R.id.tv_email);
        this.explanationLL = (LinearLayout) view.findViewById(R.id.explanationLL);
        this.explanationTV = (TextView) view.findViewById(R.id.explanationTV);
        this.nestedSV = (NestedScrollView) view.findViewById(R.id.nestedSV);
        this.parent_view = view.findViewById(android.R.id.content);
        this.llTimerNegPos = (LinearLayout) view.findViewById(R.id.llTimerNegPos);
        this.tv_timer = (TextView) view.findViewById(R.id.tv_timer);
        this.pos_mark = (TextView) view.findViewById(R.id.pos_mark);
        this.neg_mark = (TextView) view.findViewById(R.id.neg_mark);
        this.mandatoryType = (TextView) view.findViewById(R.id.mandatoryType);
        this.multiple_choice_instruction = (TextView) view.findViewById(R.id.multiple_choice_instruction);
        this.LinearLayoutList = new ArrayList();
        this.parentList = new ArrayList();
        this.tvList = new ArrayList();
        if (BuildConfig.FLAVOR.equalsIgnoreCase("champion")) {
            this.llTimerNegPos.setVisibility(8);
        } else {
            this.llTimerNegPos.setVisibility(0);
        }
        ((TestBaseActivity) requireActivity()).perQuestionTimer(this.tv_timer);
        if (((TestBaseActivity) requireActivity()).testseriesBase != null && ((TestBaseActivity) requireActivity()).testseriesBase.getData() != null && ((TestBaseActivity) requireActivity()).testseriesBase.getData().getQuestionReportOptions() != null && !((TestBaseActivity) requireActivity()).testseriesBase.getData().getQuestionReportOptions().isEmpty()) {
            this.tvReportError.setVisibility(0);
        } else {
            this.tvReportError.setVisibility(8);
        }
        if (((TestBaseActivity) requireActivity()).questionBankList != null && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position) != null && !TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSection_question_behaviour())) {
            this.mandatoryType.setVisibility(0);
            if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSection_question_behaviour().equalsIgnoreCase("1")) {
                this.mandatoryType.setText(Html.fromHtml("(Mandatory<sup>*</sup>)"));
            } else {
                this.mandatoryType.setText(Html.fromHtml("(Optional<sup>*</sup>)"));
            }
        } else {
            this.mandatoryType.setVisibility(8);
        }
        if (((TestBaseActivity) requireActivity()).questionBankList != null && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position) != null && !TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getQuestionType()) && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getQuestionType().equalsIgnoreCase("MC")) {
            this.multiple_choice_instruction.setVisibility(0);
        } else {
            this.multiple_choice_instruction.setVisibility(8);
        }
        if (((TestBaseActivity) requireActivity()).questionBankList != null && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position) != null && !TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getPosMarks())) {
            this.pos_mark.setVisibility(0);
            this.pos_mark.setText("+ " + ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getPosMarks());
        } else {
            this.pos_mark.setVisibility(8);
        }
        if (((TestBaseActivity) requireActivity()).questionBankList != null && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position) != null && !TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getNegMarks())) {
            this.neg_mark.setVisibility(0);
            this.neg_mark.setText("- " + ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getNegMarks());
        } else {
            this.neg_mark.setVisibility(8);
        }
        String str = this.questionType;
        str.hashCode();
        if (str.equals("MT")) {
            this.mcqoptionsLL.setVisibility(8);
            this.LLmatchinquestion.setVisibility(0);
            String question = ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getQuestion();
            this.tvQuestion.setBackgroundColor(0);
            this.tvQuestion.setLayerType(2, null);
            this.tvQuestion.getSettings().setJavaScriptEnabled(true);
            this.tvQuestion.getSettings().setGeolocationEnabled(true);
            this.tvQuestion.setLongClickable(false);
            if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type().equalsIgnoreCase("1") || ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type().equalsIgnoreCase("2")) {
                Helper.testQuestionFont(this.tvQuestion, this.position, question, ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type());
            } else {
                Helper.TestWebHTMLLoad(this.tvQuestion, Helper.getHTMLWidthForImage("<p style='font-family:sans-serif !important; font-size:16px; margin:0;'>Q-" + (this.position + 1) + ".</p>" + question));
            }
            this.tvQuestion.setLongClickable(false);
            this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.question_layout1));
            addMachingQuestionOption();
        } else if (!str.equals("FIB")) {
            this.mcqoptionsLL.setVisibility(0);
            this.LLmatchinquestion.setVisibility(8);
            String strTrim = ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getQuestion().trim();
            this.tvQuestion.setBackgroundColor(0);
            this.tvQuestion.setLayerType(2, null);
            this.tvQuestion.getSettings().setJavaScriptEnabled(true);
            this.tvQuestion.getSettings().setGeolocationEnabled(true);
            if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type().equalsIgnoreCase("1") || ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type().equalsIgnoreCase("2")) {
                Helper.testQuestionFont(this.tvQuestion, this.position, strTrim, ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type());
            } else {
                Helper.TestWebHTMLLoad(this.tvQuestion, Helper.getHTMLWidthForImage("<p style='font-family:sans-serif !important; font-size:16px; margin:0;'>Q-" + (this.position + 1) + ".</p>" + strTrim));
            }
            this.tvQuestion.setLongClickable(false);
            addQuestionOption();
        }
        if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getParagraphText())) {
            this.tvQuestionFib.setVisibility(8);
        } else {
            this.tvQuestionFib.setVisibility(0);
            String strTrim2 = ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getParagraphText().trim();
            if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type().equalsIgnoreCase("1")) {
                Helper.TestWebHTMLLoad(this.tvQuestionFib, "<html><head><style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/fonts/kruti_dev.ttf\")}body {font-family: MyFont;font-size: medium;text-align: justify;}</style></head><body>" + strTrim2.replaceAll("\\<.*?\\>", "") + "</body></html>");
            } else if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type().equalsIgnoreCase("2")) {
                Helper.testOptionFont(this.tvQuestionFib, strTrim2, ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type());
            } else {
                Helper.TestWebHTMLLoad(this.tvQuestionFib, strTrim2);
            }
        }
        this.tv_uid.setText(this.activity.getResources().getString(R.string.question_id) + ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getId());
        if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).isMarkForReview()) {
            this.markForReview.setVisibility(8);
            this.unmarkForReview.setVisibility(0);
        } else {
            this.markForReview.setVisibility(0);
            this.unmarkForReview.setVisibility(8);
        }
        this.imgBookmark.setOnClickListener(this);
        this.checkBoxGuess.setOnClickListener(this);
        this.markForReview.setOnClickListener(this);
        this.remove_mark_for_review.setOnClickListener(this);
        this.save_mark_for_review.setOnClickListener(this);
        this.unmarkForReview.setOnClickListener(this);
        this.tvReportError.setOnClickListener(this);
        if (SharedPreference.getInstance().getString(Const.BOOK_MARK) != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.BOOK_MARK)) && SharedPreference.getInstance().getString(Const.BOOK_MARK).equalsIgnoreCase("1")) {
            this.imgBookmark.setVisibility(0);
        } else {
            this.imgBookmark.setVisibility(8);
        }
        if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
            if (((TestBaseActivity) requireActivity()).questionDumpList.get(this.position).getIs_bookmarked().equals("1")) {
                this.imgBookmark.setImageResource(R.mipmap.bookmark_selected);
            } else {
                this.imgBookmark.setImageResource(R.mipmap.bookmark_unselected);
            }
        } else if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getIs_bookmarked().equals("1")) {
            this.imgBookmark.setImageResource(R.mipmap.bookmark_selected);
        } else {
            this.imgBookmark.setImageResource(R.mipmap.bookmark_unselected);
        }
        if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getIsguess().equals("1")) {
            this.checkBoxGuess.setChecked(true);
        } else {
            this.checkBoxGuess.setChecked(false);
        }
        if (((TestBaseActivity) requireActivity()).data != null && ((TestBaseActivity) requireActivity()).data.getUserDetails() != null) {
            this.tvEmail.setText(((TestBaseActivity) requireActivity()).data.getUserDetails().getEmail());
        } else {
            this.tvEmail.setText(SharedPreference.getInstance().getLoggedInUser().getEmail());
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
        for (int i = 1; i <= 10 && !this.status; i++) {
            switch (i) {
                case 1:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption1())) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("1", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption1(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                        continue;
                    }
                    break;
                case 2:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption2())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("2", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption2(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
                case 3:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption3())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("3", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption3(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
                case 4:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption4())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("4", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption4(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
                case 5:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption5())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("5", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption5(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
                case 6:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption6())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("6", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption6(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
                case 7:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption7())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("7", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption7(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
                case 8:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption8())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("8", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption8(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
                case 9:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption9())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("9", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption9(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
                case 10:
                    if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption10())) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("10", ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption10(), ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type(), false, i - 1));
                    }
                    break;
            }
        }
        this.status = false;
    }

    private void addMachingQuestionOption() {
        if (((TestBaseActivity) requireActivity()).items1 != null) {
            ((TestBaseActivity) requireActivity()).items1.clear();
        } else {
            ((TestBaseActivity) requireActivity()).items1 = new ArrayList();
        }
        if (((TestBaseActivity) requireActivity()).items2 != null) {
            ((TestBaseActivity) requireActivity()).items2.clear();
        } else {
            ((TestBaseActivity) requireActivity()).items2 = new ArrayList();
        }
        for (int i = 1; i <= 10 && !this.status1; i++) {
            switch (i) {
                case 1:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption1())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption1().split("\\s*##\\s*")).size() == 2) {
                            int i2 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("1", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption1().split("\\s*##\\s*")).get(1), i2));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("1", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption1().split("\\s*##\\s*")).get(0), i2));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption2())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption2().split("\\s*##\\s*")).size() == 2) {
                            int i3 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("2", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption2().split("\\s*##\\s*")).get(1), i3));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("2", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption2().split("\\s*##\\s*")).get(0), i3));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption3())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption3().split("\\s*##\\s*")).size() == 2) {
                            int i4 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("3", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption3().split("\\s*##\\s*")).get(1), i4));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("3", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption3().split("\\s*##\\s*")).get(0), i4));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 4:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption4())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption4().split("\\s*##\\s*")).size() == 2) {
                            int i5 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("4", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption4().split("\\s*##\\s*")).get(1), i5));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("4", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption4().split("\\s*##\\s*")).get(0), i5));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 5:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption5())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption5().split("\\s*##\\s*")).size() == 2) {
                            int i6 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("5", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption5().split("\\s*##\\s*")).get(1), i6));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("5", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption5().split("\\s*##\\s*")).get(0), i6));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 6:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption6())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption6().split("\\s*##\\s*")).size() == 2) {
                            int i7 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("6", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption6().split("\\s*##\\s*")).get(1), i7));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("6", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption6().split("\\s*##\\s*")).get(0), i7));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 7:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption7())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption7().split("\\s*##\\s*")).size() == 2) {
                            int i8 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("7", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption7().split("\\s*##\\s*")).get(1), i8));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("7", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption7().split("\\s*##\\s*")).get(0), i8));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 8:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption8())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption8().split("\\s*##\\s*")).size() == 2) {
                            int i9 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("8", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption8().split("\\s*##\\s*")).get(1), i9));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("8", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption8().split("\\s*##\\s*")).get(0), i9));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 9:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption9())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption9().split("\\s*##\\s*")).size() == 2) {
                            int i10 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("9", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption9().split("\\s*##\\s*")).get(1), i10));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("9", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption9().split("\\s*##\\s*")).get(0), i10));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 10:
                    if (!TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption10())) {
                        if (Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption10().split("\\s*##\\s*")).size() == 2) {
                            int i11 = i - 1;
                            ((TestBaseActivity) requireActivity()).items1.add(new Social("10", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption10().split("\\s*##\\s*")).get(1), i11));
                            ((TestBaseActivity) requireActivity()).items2.add(new Social("10", (String) Arrays.asList(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getOption10().split("\\s*##\\s*")).get(0), i11));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
            }
        }
        if (!this.status1) {
            int[] intArray = getResources().getIntArray(R.array.mdcolor_random);
            int i12 = intArray[new Random().nextInt(intArray.length)];
            AdapterMatchingListDrag adapterMatchingListDrag = new AdapterMatchingListDrag(this.activity, ((TestBaseActivity) requireActivity()).items1, this.position);
            this.adapterMatchingListDrag = adapterMatchingListDrag;
            this.rvmatchinquestion2.setAdapter(adapterMatchingListDrag);
            AdapterMatchingListNormal adapterMatchingListNormal = new AdapterMatchingListNormal(this.activity, ((TestBaseActivity) requireActivity()).items2, intArray, this.position);
            this.adapterMatchingListNormal = adapterMatchingListNormal;
            this.rvmatchinquestion1.setAdapter(adapterMatchingListNormal);
            this.adapterMatchingListDrag.setOnItemClickListener(new AdapterMatchingListDrag.OnItemClickListener() { // from class: com.appnew.android.testmodule.fragment.SC_TestSeriesFragment.2
                @Override // com.appnew.android.testmodule.adapter.AdapterMatchingListDrag.OnItemClickListener
                public void onItemClick(View view, Social obj, int p, int bg, int circle, boolean select) {
                    if (select) {
                        SC_TestSeriesFragment.this.selected.add(new mcSelection(p, bg, circle, select));
                        ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).setSelcted(SC_TestSeriesFragment.this.selected);
                        ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).setIsanswer(true, SC_TestSeriesFragment.this.selectedAnswerposition + 1, SC_TestSeriesFragment.this.tags);
                        if (!((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("H/E")) {
                            if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("E/H")) {
                                ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(SC_TestSeriesFragment.this.position).setSelcted(SC_TestSeriesFragment.this.selected);
                                ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(SC_TestSeriesFragment.this.position).setIsanswer(true, SC_TestSeriesFragment.this.selectedAnswerposition + 1, SC_TestSeriesFragment.this.tags);
                            }
                        } else {
                            ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(SC_TestSeriesFragment.this.position).setSelcted(SC_TestSeriesFragment.this.selected);
                            ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(SC_TestSeriesFragment.this.position).setIsanswer(true, SC_TestSeriesFragment.this.selectedAnswerposition + 1, SC_TestSeriesFragment.this.tags);
                        }
                    } else {
                        int i13 = 0;
                        while (true) {
                            if (i13 >= ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().size()) {
                                break;
                            }
                            if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().get(i13).getPosition() == p) {
                                ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().remove(i13);
                                if (!((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("H/E")) {
                                    if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("E/H")) {
                                        ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(SC_TestSeriesFragment.this.position).getSelcted().remove(i13);
                                    }
                                } else {
                                    ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(SC_TestSeriesFragment.this.position).getSelcted().remove(i13);
                                }
                            } else {
                                i13++;
                            }
                        }
                    }
                    boolean z = false;
                    for (int i14 = 0; i14 < ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().size(); i14++) {
                        if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().get(i14).isSelect()) {
                            z = true;
                        }
                    }
                    if (z) {
                        SC_TestSeriesFragment.this.tags.clear();
                        for (int i15 = 0; i15 < ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).items1.size(); i15++) {
                            int i16 = 0;
                            while (true) {
                                if (i16 >= ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().size()) {
                                    break;
                                }
                                if (!((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().get(i16).isSelect()) {
                                    SC_TestSeriesFragment.this.tags.add(i15, 0);
                                    break;
                                }
                                int i17 = 0;
                                while (true) {
                                    if (i17 < TestBaseActivity.SAMPLE_CIRCLE.length) {
                                        int circlecolor_code = ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().get(i16).getCirclecolor_code();
                                        if (circlecolor_code == TestBaseActivity.SAMPLE_CIRCLE[i17]) {
                                            SC_TestSeriesFragment.this.tags.add(Integer.valueOf(((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().get(i16).getPosition() + 1));
                                            break;
                                        }
                                        i17++;
                                    }
                                }
                                i16++;
                            }
                        }
                        if (!((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("H/E")) {
                            if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("E/H")) {
                                ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(SC_TestSeriesFragment.this.position).setIsanswer(true, 1, SC_TestSeriesFragment.this.tags);
                            }
                        } else {
                            ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(SC_TestSeriesFragment.this.position).setIsanswer(true, 1, SC_TestSeriesFragment.this.tags);
                        }
                        ((TestBaseActivity) SC_TestSeriesFragment.this.activity).questionBankList.get(SC_TestSeriesFragment.this.position).setIsanswer(true, 1, SC_TestSeriesFragment.this.tags);
                        return;
                    }
                    ((TestBaseActivity) SC_TestSeriesFragment.this.activity).questionBankList.get(SC_TestSeriesFragment.this.position).setIsanswer(false, 0);
                    if (!((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("H/E")) {
                        if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("E/H")) {
                            ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(SC_TestSeriesFragment.this.position).setIsanswer(false, 0);
                            return;
                        }
                        return;
                    }
                    ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(SC_TestSeriesFragment.this.position).setIsanswer(false, 0);
                }
            });
            this.adapterMatchingListDrag.setMachingOnDrag(new AdapterMatchingListDrag.MachingOnDrag() { // from class: com.appnew.android.testmodule.fragment.SC_TestSeriesFragment.3
                @Override // com.appnew.android.testmodule.adapter.AdapterMatchingListDrag.MachingOnDrag
                public void sendOnclickInd(int p) {
                    if (SC_TestSeriesFragment.this.adapterMatchingListNormal != null) {
                        int i13 = 0;
                        while (true) {
                            if (i13 >= ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted2().size()) {
                                break;
                            }
                            if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted2().get(i13).getPosition() == p) {
                                ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted2().remove(i13);
                                break;
                            }
                            i13++;
                        }
                        SC_TestSeriesFragment.this.adapterMatchingListNormal.notifyDataSetChanged();
                    }
                }
            });
            this.adapterMatchingListNormal.setMachingOnDrag(new AdapterMatchingListNormal.MachingOnDrag() { // from class: com.appnew.android.testmodule.fragment.SC_TestSeriesFragment.4
                @Override // com.appnew.android.testmodule.adapter.AdapterMatchingListNormal.MachingOnDrag
                public void sendOnclickInd(int p) {
                    ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().remove(p);
                    if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted().size() == 0) {
                        TestBaseActivity.nestselected = false;
                    }
                    TestBaseActivity.sameselected = false;
                    SC_TestSeriesFragment.this.adapterMatchingListDrag.notifyDataSetChanged();
                }
            });
            this.adapterMatchingListNormal.setOnItemClickListener(new AdapterMatchingListNormal.OnItemClickListener() { // from class: com.appnew.android.testmodule.fragment.SC_TestSeriesFragment.5
                @Override // com.appnew.android.testmodule.adapter.AdapterMatchingListNormal.OnItemClickListener
                public void onItemClick(View view, int p, Social obj, int bg, int circle, boolean select) {
                    if (select) {
                        SC_TestSeriesFragment.this.selected2.add(new mcSelection(p, bg, circle, select));
                        ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).setSelcted2(SC_TestSeriesFragment.this.selected2);
                        return;
                    }
                    for (int i13 = 0; i13 < ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted2().size(); i13++) {
                        if (((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted2().get(i13).getPosition() == p) {
                            ((TestBaseActivity) SC_TestSeriesFragment.this.requireActivity()).questionBankList.get(SC_TestSeriesFragment.this.position).getSelcted2().remove(i13);
                            return;
                        }
                    }
                }
            });
        }
        this.status1 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public LinearLayout initMCQOptionView(String str, String str2, String str3, boolean z, int i) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.layout_option_test_view, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.optionIconTV);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.optionTextTV2);
        MathView mathView = (MathView) linearLayout.findViewById(R.id.optionTextTV);
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
        linearLayout.setTag(Integer.valueOf(i));
        if (str2.contains("<img src=") || str2.contains("math-tex") || str2.contains("https://") || str2.contains("http://") || str2.contains("<img style")) {
            textView2.setVisibility(8);
            mathView.setVisibility(0);
            mathView.getSettings().setJavaScriptEnabled(true);
            if (str3.equalsIgnoreCase("1")) {
                setKrutiDevFont(textView2, str2);
            } else if (str3.equalsIgnoreCase("2")) {
                Helper.testOptionFont(mathView, str2, str3);
            } else {
                Helper.TestWebHTMLLoad(mathView, Helper.getHTMLWidthForImage(str2));
            }
        } else {
            textView2.setVisibility(0);
            mathView.setVisibility(8);
            if (!str3.equalsIgnoreCase("2") && (str2.contains("&lt") || str2.contains("&gt"))) {
                str2 = String.valueOf(Html.fromHtml(str2));
            }
            if (str3.equalsIgnoreCase("1")) {
                setKrutiDevFont(textView2, str2);
            } else if (str3.equalsIgnoreCase("2")) {
                textView2.setVisibility(8);
                mathView.setVisibility(0);
                Helper.testOptionFont(mathView, str2, str3);
            } else {
                textView2.setVisibility(8);
                mathView.setVisibility(0);
                Helper.TestWebHTMLLoad(mathView, Helper.getHTMLWidthForImage(str2));
            }
        }
        String str4 = this.questionType;
        int iHashCode = str4.hashCode();
        if (iHashCode != 2454) {
            if (iHashCode != 2551) {
                if (iHashCode != 2640) {
                    if (iHashCode != 2674) {
                        if (iHashCode == 69599) {
                            str4.equals("FIB");
                        }
                    } else if (str4.equals("TF")) {
                        if (((TestBaseActivity) requireActivity()).questionBankList2 == null || ((TestBaseActivity) requireActivity()).questionBankList2.size() <= 0) {
                            if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).isanswer() && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() != 0 && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() - 1 == i) {
                                linearLayout.setSelected(true);
                            }
                        } else if (((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).isanswer() && ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).getAnswerPosttion() != 0 && ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).getAnswerPosttion() - 1 == i) {
                            linearLayout.setSelected(true);
                        }
                    }
                } else if (str4.equals("SC")) {
                    if (((TestBaseActivity) requireActivity()).questionBankList2 == null || ((TestBaseActivity) requireActivity()).questionBankList2.size() <= 0) {
                        if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).isanswer() && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() != 0 && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() - 1 == i) {
                            linearLayout.setSelected(true);
                        }
                    } else if (((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).isanswer() && ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).getAnswerPosttion() != 0 && ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).getAnswerPosttion() - 1 == i) {
                        linearLayout.setSelected(true);
                    }
                }
            } else if (str4.equals("PG")) {
                if (((TestBaseActivity) requireActivity()).questionBankList2 == null || ((TestBaseActivity) requireActivity()).questionBankList2.size() <= 0) {
                    if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).isanswer() && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() != 0 && ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getAnswerPosttion() - 1 == i) {
                        linearLayout.setSelected(true);
                    }
                } else if (((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).isanswer() && ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).getAnswerPosttion() != 0 && ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).getAnswerPosttion() - 1 == i) {
                    linearLayout.setSelected(true);
                }
            }
        } else if (str4.equals("MC")) {
            if (((TestBaseActivity) requireActivity()).questionBankList2 == null || ((TestBaseActivity) requireActivity()).questionBankList2.size() <= 0) {
                if (((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedValue() != null && ((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedValue().contains(Integer.valueOf(i))) {
                    linearLayout.setSelected(true);
                    this.selectedValue = ((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedValue();
                }
            } else if (((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedValue() != null && ((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedValue().contains(Integer.valueOf(i))) {
                linearLayout.setSelected(true);
                this.selectedValue = ((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedValue();
            }
        }
        this.LinearLayoutList.add(linearLayout);
        this.parentList.add(this.parentLL);
        this.tvList.add(textView);
        linearLayout.setOnClickListener(this.onClickListener);
        return linearLayout;
    }

    private void setKrutiDevFont(TextView textView, String text) {
        String strReplaceAll = text.replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;", "");
        textView.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), "fonts/kruti_dev.ttf"));
        textView.setText(strReplaceAll);
    }

    private void setNaradMuniFont(TextView textView, String text) {
        String strReplaceAll = text.replaceAll("\\<.*?\\>", "");
        textView.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), "fonts/Narad.ttf"));
        textView.setText(strReplaceAll);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkBox /* 2131362544 */:
                if (((CompoundButton) view).isChecked()) {
                    System.out.println("Checked");
                    this.guess = "1";
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIsguess(this.guess);
                    if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIsguess(this.guess);
                    } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsguess(this.guess);
                    }
                } else {
                    this.guess = "0";
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIsguess(this.guess);
                    if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIsguess(this.guess);
                    } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsguess(this.guess);
                    }
                }
                break;
            case R.id.img_bookmark /* 2131363689 */:
                if (((TestBaseActivity) requireActivity()).questionBankList2.size() > 0) {
                    if (((TestBaseActivity) requireActivity()).questionDumpList.get(this.position).getIs_bookmarked().equals("1")) {
                        ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setIs_bookmarked("0");
                        ((TestBaseActivity) requireActivity()).questionDumpList.get(this.position).setIs_bookmarked("0");
                        if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                            ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIs_bookmarked("0");
                        } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                            ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIs_bookmarked("0");
                        }
                        this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_unselected));
                        Toast.makeText(this.activity, this.activity.getResources().getString(R.string.unboomark), 0).show();
                    } else {
                        ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setIs_bookmarked("1");
                        ((TestBaseActivity) requireActivity()).questionDumpList.get(this.position).setIs_bookmarked("1");
                        if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                            ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIs_bookmarked("1");
                        } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                            ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIs_bookmarked("1");
                        }
                        if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
                            this.questionId = ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).getId();
                            this.networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", false, false);
                        } else {
                            this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_selected));
                            Toast.makeText(this.activity, this.activity.getResources().getString(R.string.boomark), 0).show();
                        }
                    }
                } else if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getIs_bookmarked().equals("1")) {
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIs_bookmarked("0");
                    if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIs_bookmarked("0");
                    } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIs_bookmarked("0");
                    }
                    this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_unselected));
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.unboomark), 0).show();
                } else {
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIs_bookmarked("1");
                    if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIs_bookmarked("1");
                    } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIs_bookmarked("1");
                    }
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
                        this.questionId = ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getId();
                        this.networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", false, false);
                    } else {
                        this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_selected));
                        Toast.makeText(this.activity, this.activity.getResources().getString(R.string.boomark), 0).show();
                    }
                }
                break;
            case R.id.mark_for_review /* 2131364196 */:
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.marked_for_review), 0).show();
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setMarkForReview(true);
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIssaveMarkForReview(false);
                if (((TestBaseActivity) requireActivity()).questionBankList2.size() > 0) {
                    ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setMarkForReview(true);
                    ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setIssaveMarkForReview(false);
                }
                if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setMarkForReview(true);
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIssaveMarkForReview(false);
                } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setMarkForReview(true);
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIssaveMarkForReview(false);
                }
                ((TestBaseActivity) requireActivity()).notifynumberApater();
                this.markForReview.setVisibility(8);
                this.unmarkForReview.setVisibility(0);
                break;
            case R.id.remove_mark_for_review /* 2131365044 */:
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.remove_amp_marked_for_review), 0).show();
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIssaveMarkForReview(false);
                if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIssaveMarkForReview(false);
                } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIssaveMarkForReview(false);
                }
                ((TestBaseActivity) requireActivity()).notifynumberApater();
                break;
            case R.id.save_mark_for_review /* 2131365228 */:
                if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).isanswer()) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.save_and_marked_for_review), 0).show();
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIssaveMarkForReview(true);
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setMarkForReview(false);
                    if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIssaveMarkForReview(true);
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setMarkForReview(false);
                    } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIssaveMarkForReview(true);
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setMarkForReview(false);
                    }
                    ((TestBaseActivity) requireActivity()).notifynumberApater();
                    this.markForReview.setVisibility(0);
                    this.unmarkForReview.setVisibility(8);
                } else {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.please_give_answer), 0).show();
                }
                break;
            case R.id.tv_report_error /* 2131366120 */:
                if (((TestBaseActivity) requireActivity()).testseriesBase != null && ((TestBaseActivity) requireActivity()).testseriesBase.getData() != null && ((TestBaseActivity) requireActivity()).testseriesBase.getData().getQuestionReportOptions() != null && !((TestBaseActivity) requireActivity()).testseriesBase.getData().getQuestionReportOptions().isEmpty()) {
                    ((TestBaseActivity) requireActivity()).showPopupErrorTest(((TestBaseActivity) requireActivity()).testseriesBase.getData().getQuestionReportOptions());
                } else {
                    Toast.makeText(requireActivity(), this.activity.getResources().getString(R.string.no_data_found), 1).show();
                }
                break;
            case R.id.unmark_for_review /* 2131366235 */:
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.unmarked_for_review), 0).show();
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setMarkForReview(false);
                if (((TestBaseActivity) requireActivity()).questionBankList2.size() > 0) {
                    ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setMarkForReview(false);
                }
                if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setMarkForReview(false);
                } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setMarkForReview(false);
                }
                ((TestBaseActivity) requireActivity()).notifynumberApater();
                this.markForReview.setVisibility(0);
                this.unmarkForReview.setVisibility(8);
                break;
        }
    }

    public void refereshPage() {
        int i = 0;
        if (this.questionType.equalsIgnoreCase("MT")) {
            for (int i2 = 0; i2 < ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSelcted().size(); i2++) {
                if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSelcted().get(i2).isSelect()) {
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSelcted().clear();
                }
            }
            this.adapterMatchingListDrag.notifyDataSetChanged();
            for (int i3 = 0; i3 < ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSelcted2().size(); i3++) {
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSelcted2().clear();
            }
            this.adapterMatchingListNormal.notifyDataSetChanged();
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                for (int i4 = 0; i4 < ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted().size(); i4++) {
                    if (((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted().get(i4).isSelect()) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted().clear();
                    }
                }
                this.adapterMatchingListDrag.notifyDataSetChanged();
                for (int i5 = 0; i5 < ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted2().size(); i5++) {
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted2().clear();
                }
                this.adapterMatchingListNormal.notifyDataSetChanged();
            } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                for (int i6 = 0; i6 < ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted().size(); i6++) {
                    if (((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted().get(i6).isSelect()) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted().clear();
                    }
                }
                this.adapterMatchingListDrag.notifyDataSetChanged();
                for (int i7 = 0; i7 < ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted2().size(); i7++) {
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted2().clear();
                }
                this.adapterMatchingListNormal.notifyDataSetChanged();
            }
        } else if (((TestBaseActivity) requireActivity()).questionBankList2.size() > 0) {
            ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setIsanswer(false, 0);
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIsanswer(false, 0);
            } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsanswer(false, 0);
            }
            if (((TestBaseActivity) requireActivity()).data.getQuestionsHindi() != null && ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().size() > 0) {
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setAnspositions("-1");
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setSelectedValue(new ArrayList<>());
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setAnswers(new ArrayList<>());
            }
            if (((TestBaseActivity) requireActivity()).data.getQuestions() != null && ((TestBaseActivity) requireActivity()).data.getQuestions().size() > 0) {
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setAnspositions("-1");
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setSelectedValue(new ArrayList<>());
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setAnswers(new ArrayList<>());
            }
            ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setAnspositions("-1");
            ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setSelectedValue(new ArrayList<>());
            ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setAnswers(new ArrayList<>());
            this.checkBoxGuess.setChecked(false);
            this.guess = "0";
            for (int i8 = 0; i8 < this.LinearLayoutList.size(); i8++) {
                this.LinearLayoutList.get(i8).setSelected(false);
            }
        } else {
            ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIsanswer(false, 0);
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIsanswer(false, 0);
            } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsanswer(false, 0);
            }
            if (((TestBaseActivity) requireActivity()).data.getQuestionsHindi() != null && ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().size() > 0) {
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setAnspositions("-1");
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setSelectedValue(new ArrayList<>());
                ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setAnswers(new ArrayList<>());
            }
            if (((TestBaseActivity) requireActivity()).data.getQuestions() != null && ((TestBaseActivity) requireActivity()).data.getQuestions().size() > 0) {
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setAnspositions("-1");
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setSelectedValue(new ArrayList<>());
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setAnswers(new ArrayList<>());
            }
            ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setAnspositions("-1");
            ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setSelectedValue(new ArrayList<>());
            ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setAnswers(new ArrayList<>());
            this.checkBoxGuess.setChecked(false);
            this.guess = "0";
            for (int i9 = 0; i9 < this.LinearLayoutList.size(); i9++) {
                this.LinearLayoutList.get(i9).setSelected(false);
            }
        }
        if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
            if (this.questionType.equalsIgnoreCase("MT")) {
                for (int i10 = 0; i10 < ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted().size(); i10++) {
                    if (((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted().get(i10).isSelect()) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted().clear();
                    }
                }
                this.adapterMatchingListDrag.notifyDataSetChanged();
                while (i < ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted2().size()) {
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).getSelcted2().clear();
                    i++;
                }
                this.adapterMatchingListNormal.notifyDataSetChanged();
                return;
            }
            ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIsanswer(false, 0);
            this.checkBoxGuess.setChecked(false);
            this.guess = "0";
            for (int i11 = 0; i11 < this.LinearLayoutList.size(); i11++) {
                this.LinearLayoutList.get(i11).setSelected(false);
            }
            return;
        }
        if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
            if (this.questionType.equalsIgnoreCase("MT")) {
                for (int i12 = 0; i12 < ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted().size(); i12++) {
                    if (((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted().get(i12).isSelect()) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted().clear();
                    }
                }
                this.adapterMatchingListDrag.notifyDataSetChanged();
                while (i < ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted2().size()) {
                    ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).getSelcted2().clear();
                    i++;
                }
                this.adapterMatchingListNormal.notifyDataSetChanged();
                return;
            }
            ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIsanswer(false, 0);
            this.checkBoxGuess.setChecked(false);
            this.guess = "0";
            for (int i13 = 0; i13 < this.LinearLayoutList.size(); i13++) {
                this.LinearLayoutList.get(i13).setSelected(false);
            }
        }
    }

    @Override // com.appnew.android.testmodule.interfaces.MachingOnDrag
    public void sendOnclickInd(int p) {
        if (this.adapterMatchingListNormal != null) {
            int i = 0;
            while (true) {
                if (i >= ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSelcted2().size()) {
                    break;
                }
                if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSelcted2().get(i).getPosition() == p) {
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getSelcted2().remove(i);
                    break;
                }
                i++;
            }
            this.adapterMatchingListNormal.notifyDataSetChanged();
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_ADD_TO_BOOKMARK)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setContent_id(this.questionId);
        encryptionData.setContent_type("0");
        encryptionData.setIs_unbookmarked("0");
        return service.addPdfBookMark(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_ADD_TO_BOOKMARK)) {
            if (jsonObject.optString("status").equals("true")) {
                this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_selected));
                Toast.makeText(this.activity, jsonObject.optString("message"), 0).show();
            } else {
                RetrofitResponse.GetApiData(this.activity, jsonObject.optString("auth_code"), jsonObject.optString("message"), false);
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this.activity, jsonstring, 0).show();
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
                this.mDrawable.setBounds(0, 0, SC_TestSeriesFragment.this.empty.getIntrinsicWidth(), SC_TestSeriesFragment.this.empty.getIntrinsicHeight());
                this.mDrawable.setLevel(1);
            }
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

    private void setHtmlinWebView(WebView webView, String html) {
        try {
            webView.loadDataWithBaseURL("", "<html><body>" + ("<div onClick=\"showAndroidToast('Hello Android!')\" >" + html + "</div>\n\n<script type=\"text/javascript\">\n    function showAndroidToast(toast) {\n        Android.showToast(toast);\n    }\n</script>") + "</body></html>", "text/html; charset=UTF-8", null, "");
            webView.setBackgroundColor(0);
            webView.setLayerType(2, null);
            webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.testmodule.fragment.SC_TestSeriesFragment.6
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View v) {
                    return true;
                }
            });
            webView.setLongClickable(false);
            webView.setHapticFeedbackEnabled(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Spanned removeImageSpanObjects(String inStr) {
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) Html.fromHtml(inStr.trim());
        for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class)) {
            if (obj instanceof ImageSpan) {
                ImageSpan imageSpan = (ImageSpan) obj;
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(imageSpan), spannableStringBuilder.getSpanEnd(imageSpan), (CharSequence) "");
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence stripHtml(String s) {
        return Html.fromHtml(s).toString().replace('\n', ' ').replace(Typography.nbsp, ' ').replace((char) 65532, ' ').trim();
    }

    private CharSequence noTrailingwhiteLines(CharSequence text) {
        if (!text.toString().isEmpty()) {
            while (text.charAt(text.length() - 1) == '\n') {
                try {
                    text = text.subSequence(0, text.length() - 1);
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return text;
    }

    public void setMarkForReviewStatus() {
        TestBaseActivity testBaseActivity = (TestBaseActivity) getActivity();
        if (testBaseActivity != null && testBaseActivity.questionBankList.get(this.position).isMarkForReview()) {
            this.markForReview.setVisibility(8);
            this.unmarkForReview.setVisibility(0);
        } else {
            this.markForReview.setVisibility(0);
            this.unmarkForReview.setVisibility(8);
        }
    }
}
