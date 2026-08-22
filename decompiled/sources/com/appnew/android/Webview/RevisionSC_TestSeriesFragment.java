package com.appnew.android.Webview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Progress;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.adapter.AdapterMatchingListDrag;
import com.appnew.android.testmodule.adapter.AdapterMatchingListNormal;
import com.appnew.android.testmodule.interfaces.MachingOnDrag;
import com.appnew.android.testmodule.model.Social;
import com.appnew.android.testmodule.model.mcSelection;
import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class RevisionSC_TestSeriesFragment extends MainFragment implements View.OnClickListener, Html.ImageGetter, MachingOnDrag {
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
    private ItemTouchHelper mItemTouchHelper;
    Progress mProgress;
    private TextView markForReview;
    LinearLayout mcqoptionsLL;
    NestedScrollView nestedSV;
    private NetworkCall networkCall;
    LinearLayout parentLL;
    List<View> parentList;
    View parent_view;
    int position;
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
    private TextView tvQuestionFib;
    private TextView tvReportError;
    private TextView tv_uid;
    private TextView unmarkForReview;
    int count = 0;
    ArrayList<Integer> selectedValue = new ArrayList<>();
    ArrayList<mcSelection> selected = new ArrayList<>();
    ArrayList<mcSelection> selected2 = new ArrayList<>();
    ArrayList tags = new ArrayList();
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionSC_TestSeriesFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).isIssaveMarkForReview()) {
                String str = RevisionSC_TestSeriesFragment.this.questionType;
                str.hashCode();
                switch (str) {
                    case "MC":
                        RevisionSC_TestSeriesFragment.this.MC_Clicked(view);
                        break;
                    case "MT":
                    case "FIB":
                        break;
                    case "SC":
                        RevisionSC_TestSeriesFragment.this.SC_Clicked(view);
                        break;
                    case "TF":
                        RevisionSC_TestSeriesFragment.this.SC_Clicked(view);
                        break;
                    default:
                        RevisionSC_TestSeriesFragment.this.SC_Clicked(view);
                        break;
                }
                return;
            }
            Toast.makeText(RevisionSC_TestSeriesFragment.this.activity, RevisionSC_TestSeriesFragment.this.activity.getResources().getString(R.string.select_remove_and_mark_for_review), 0).show();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void SC_Clicked(View view) {
        this.selectedAnswerposition = ((Integer) view.getTag()).intValue();
        int size = this.LinearLayoutList.size();
        ArrayList arrayList = this.tags;
        if (arrayList != null) {
            arrayList.clear();
        }
        if ((!((RevisionTest) getActivity()).questionBankList.get(this.position).isanswer() && ((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() == 0) || ((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() == -1) {
            for (int i = 0; i < this.LinearLayoutList.size(); i++) {
                if (this.selectedAnswerposition == i) {
                    this.tags.add(i, "1");
                    ((RevisionTest) getActivity()).questionBankList.get(this.position).setUser_answer(((AppCompatTextView) ((LinearLayout) ((LinearLayout) this.LinearLayoutList.get(i)).getChildAt(0)).getChildAt(2)).getText().toString());
                } else {
                    this.tags.add("0");
                }
            }
            ((RevisionTest) getActivity()).questionBankList.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
        } else if (((RevisionTest) getActivity()).questionBankList.get(this.position).isanswer() && ((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() != 0 && ((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() != -1) {
            if (((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() == this.selectedAnswerposition + 1) {
                for (int i2 = 0; i2 < this.LinearLayoutList.size(); i2++) {
                    ((RevisionTest) getActivity()).questionBankList.get(this.position).setUser_answer("");
                    this.tags.add(i2, "0");
                }
                ((RevisionTest) getActivity()).questionBankList.get(this.position).setIsanswer(false, 0);
            } else {
                for (int i3 = 0; i3 < this.LinearLayoutList.size(); i3++) {
                    if (this.selectedAnswerposition == i3) {
                        this.tags.add(i3, "1");
                        ((RevisionTest) getActivity()).questionBankList.get(this.position).setUser_answer(((AppCompatTextView) ((LinearLayout) ((LinearLayout) this.LinearLayoutList.get(i3)).getChildAt(0)).getChildAt(2)).getText().toString());
                    } else {
                        this.tags.add("0");
                    }
                }
                ((RevisionTest) getActivity()).questionBankList.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, this.tags);
            }
        }
        this.explanationLL.setVisibility(8);
        for (int i4 = 0; i4 < size; i4++) {
            if (this.selectedAnswerposition == i4) {
                if (this.LinearLayoutList.get(i4).isSelected()) {
                    this.LinearLayoutList.get(i4).setSelected(false);
                } else {
                    this.LinearLayoutList.get(i4).setSelected(true);
                }
            } else {
                this.LinearLayoutList.get(i4).setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MC_Clicked(View view) {
        this.selectedAnswerposition = ((Integer) view.getTag()).intValue();
        ((RevisionTest) this.activity).questionBankList.get(this.position).getAnswer().split(Constants.SEPARATOR_COMMA);
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
            ((RevisionTest) this.activity).questionBankList.get(this.position).setSelectedValue(this.selectedValue);
        } else {
            this.LinearLayoutList.get(this.selectedAnswerposition).setSelected(true);
            if (!this.selectedValue.contains(Integer.valueOf(this.selectedAnswerposition))) {
                this.selectedValue.add(Integer.valueOf(this.selectedAnswerposition));
            }
            ((RevisionTest) this.activity).questionBankList.get(this.position).setSelectedValue(this.selectedValue);
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.LinearLayoutList.size(); i2++) {
            if (this.LinearLayoutList.get(i2).isSelected()) {
                z = true;
            }
        }
        if (z) {
            String str = "";
            for (int i3 = 0; i3 < ((RevisionTest) this.activity).questionBankList.get(this.position).getSelectedValue().size(); i3++) {
                str = str + ((RevisionTest) this.activity).questionBankList.get(this.position).getSelectedValue().get(i3) + Constants.SEPARATOR_COMMA;
            }
            this.tags.clear();
            for (int i4 = 0; i4 < this.LinearLayoutList.size(); i4++) {
                if (str.contains(String.valueOf(i4))) {
                    this.tags.add("1");
                } else {
                    this.tags.add("0");
                }
            }
            ((RevisionTest) this.activity).questionBankList.get(this.position).setIsanswer(true, this.selectedAnswerposition + 1, str, this.tags);
            return;
        }
        ((RevisionTest) this.activity).questionBankList.get(this.position).setIsanswer(false, 0);
    }

    public static RevisionSC_TestSeriesFragment newInstance(int position, String questionType) {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.POSITION, position);
        bundle.putString("questionType", questionType);
        RevisionSC_TestSeriesFragment revisionSC_TestSeriesFragment = new RevisionSC_TestSeriesFragment();
        revisionSC_TestSeriesFragment.setArguments(bundle);
        return revisionSC_TestSeriesFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_series_revision, (ViewGroup) null);
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
            this.questionType = arguments.getString("questionType", "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
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
        this.tvQuestionFib = (TextView) view.findViewById(R.id.tv_question_fib);
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
        this.LinearLayoutList = new ArrayList();
        this.parentList = new ArrayList();
        this.tvList = new ArrayList();
        this.questionType.hashCode();
        this.mcqoptionsLL.setVisibility(0);
        this.LLmatchinquestion.setVisibility(8);
        String question = ((RevisionTest) getActivity()).questionBankList.get(this.position).getQuestion();
        this.tvQuestion.setBackgroundColor(0);
        this.tvQuestion.getSettings().setJavaScriptEnabled(true);
        this.tvQuestion.getSettings().setGeolocationEnabled(true);
        this.tvQuestion.setLayerType(2, null);
        this.tvQuestion.setLongClickable(false);
        this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.question_layout1));
        Helper.showWebData(getActivity(), Helper.getHtmlUpdatedData("Q-" + (this.position + 1) + ". " + question), this.tvQuestion);
        addQuestionOption();
        if (((TestBaseActivity) requireActivity()).testseriesBase != null && ((TestBaseActivity) requireActivity()).testseriesBase.getData() != null && ((TestBaseActivity) requireActivity()).testseriesBase.getData().getQuestionReportOptions() != null && !((TestBaseActivity) requireActivity()).testseriesBase.getData().getQuestionReportOptions().isEmpty()) {
            this.tvReportError.setVisibility(0);
        } else {
            this.tvReportError.setVisibility(8);
        }
        if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getParagraphText())) {
            this.tvQuestionFib.setVisibility(8);
        } else {
            this.tvQuestionFib.setVisibility(0);
            this.tvQuestionFib.setText(Html.fromHtml(((RevisionTest) getActivity()).questionBankList.get(this.position).getParagraphText()));
        }
        this.tv_uid.setText(this.activity.getResources().getString(R.string.question_id) + ((RevisionTest) getActivity()).questionBankList.get(this.position).getId());
        if (((RevisionTest) getActivity()).questionBankList.get(this.position).isMarkForReview()) {
            this.markForReview.setVisibility(8);
            this.unmarkForReview.setVisibility(0);
        } else {
            this.markForReview.setVisibility(0);
            this.unmarkForReview.setVisibility(8);
        }
        this.checkBoxGuess.setOnClickListener(this);
        this.markForReview.setOnClickListener(this);
        this.remove_mark_for_review.setOnClickListener(this);
        this.save_mark_for_review.setOnClickListener(this);
        this.unmarkForReview.setOnClickListener(this);
        this.tvReportError.setOnClickListener(this);
        this.imgBookmark.setVisibility(8);
        if (((RevisionTest) getActivity()).questionBankList.get(this.position).getIsguess().equals("1")) {
            this.checkBoxGuess.setChecked(true);
        } else {
            this.checkBoxGuess.setChecked(false);
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
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption1())) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("1", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption1(), "11", false, i - 1));
                        continue;
                    }
                    break;
                case 2:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption2())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("2", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption2(), "11", false, i - 1));
                    }
                    break;
                case 3:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption3())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("3", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption3(), "11", false, i - 1));
                    }
                    break;
                case 4:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption4())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("4", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption4(), "11", false, i - 1));
                    }
                    break;
                case 5:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption5())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("5", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption5(), "11", false, i - 1));
                    }
                    break;
                case 6:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption6())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("6", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption6(), "11", false, i - 1));
                    }
                    break;
                case 7:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption7())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("7", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption7(), "11", false, i - 1));
                    }
                    break;
                case 8:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption8())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("8", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption8(), "11", false, i - 1));
                    }
                    break;
                case 9:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption9())) {
                        this.status = true;
                        continue;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("9", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption9(), "11", false, i - 1));
                    }
                    break;
                case 10:
                    if (TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption10())) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("10", ((RevisionTest) getActivity()).questionBankList.get(this.position).getOption10(), "11", false, i - 1));
                    }
                    break;
            }
        }
        this.status = false;
    }

    private void addMachingQuestionOption() {
        if (((RevisionTest) getActivity()).items1 != null) {
            ((RevisionTest) getActivity()).items1.clear();
        } else {
            ((RevisionTest) getActivity()).items1 = new ArrayList();
        }
        if (((RevisionTest) getActivity()).items2 != null) {
            ((RevisionTest) getActivity()).items2.clear();
        } else {
            ((RevisionTest) getActivity()).items2 = new ArrayList();
        }
        for (int i = 1; i <= 10 && !this.status1; i++) {
            switch (i) {
                case 1:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption1())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption1().split("\\s*##\\s*")).size() == 2) {
                            int i2 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("1", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption1().split("\\s*##\\s*")).get(1), i2));
                            ((RevisionTest) getActivity()).items2.add(new Social("1", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption1().split("\\s*##\\s*")).get(0), i2));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption2())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption2().split("\\s*##\\s*")).size() == 2) {
                            int i3 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("2", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption2().split("\\s*##\\s*")).get(1), i3));
                            ((RevisionTest) getActivity()).items2.add(new Social("2", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption2().split("\\s*##\\s*")).get(0), i3));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 3:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption3())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption3().split("\\s*##\\s*")).size() == 2) {
                            int i4 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("3", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption3().split("\\s*##\\s*")).get(1), i4));
                            ((RevisionTest) getActivity()).items2.add(new Social("3", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption3().split("\\s*##\\s*")).get(0), i4));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 4:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption4())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption4().split("\\s*##\\s*")).size() == 2) {
                            int i5 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("4", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption4().split("\\s*##\\s*")).get(1), i5));
                            ((RevisionTest) getActivity()).items2.add(new Social("4", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption4().split("\\s*##\\s*")).get(0), i5));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 5:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption5())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption5().split("\\s*##\\s*")).size() == 2) {
                            int i6 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("5", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption5().split("\\s*##\\s*")).get(1), i6));
                            ((RevisionTest) getActivity()).items2.add(new Social("5", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption5().split("\\s*##\\s*")).get(0), i6));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 6:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption6())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption6().split("\\s*##\\s*")).size() == 2) {
                            int i7 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("6", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption6().split("\\s*##\\s*")).get(1), i7));
                            ((RevisionTest) getActivity()).items2.add(new Social("6", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption6().split("\\s*##\\s*")).get(0), i7));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 7:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption7())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption7().split("\\s*##\\s*")).size() == 2) {
                            int i8 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("7", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption7().split("\\s*##\\s*")).get(1), i8));
                            ((RevisionTest) getActivity()).items2.add(new Social("7", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption7().split("\\s*##\\s*")).get(0), i8));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 8:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption8())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption8().split("\\s*##\\s*")).size() == 2) {
                            int i9 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("8", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption8().split("\\s*##\\s*")).get(1), i9));
                            ((RevisionTest) getActivity()).items2.add(new Social("8", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption8().split("\\s*##\\s*")).get(0), i9));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 9:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption9())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption9().split("\\s*##\\s*")).size() == 2) {
                            int i10 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("9", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption9().split("\\s*##\\s*")).get(1), i10));
                            ((RevisionTest) getActivity()).items2.add(new Social("9", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption9().split("\\s*##\\s*")).get(0), i10));
                        }
                    } else {
                        this.status1 = true;
                    }
                    break;
                case 10:
                    if (!TextUtils.isEmpty(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption10())) {
                        if (Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption10().split("\\s*##\\s*")).size() == 2) {
                            int i11 = i - 1;
                            ((RevisionTest) getActivity()).items1.add(new Social("10", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption10().split("\\s*##\\s*")).get(1), i11));
                            ((RevisionTest) getActivity()).items2.add(new Social("10", (String) Arrays.asList(((RevisionTest) getActivity()).questionBankList.get(this.position).getOption10().split("\\s*##\\s*")).get(0), i11));
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
            AdapterMatchingListDrag adapterMatchingListDrag = new AdapterMatchingListDrag(this.activity, ((RevisionTest) getActivity()).items1, this.position);
            this.adapterMatchingListDrag = adapterMatchingListDrag;
            this.rvmatchinquestion2.setAdapter(adapterMatchingListDrag);
            AdapterMatchingListNormal adapterMatchingListNormal = new AdapterMatchingListNormal(this.activity, ((RevisionTest) getActivity()).items2, intArray, this.position);
            this.adapterMatchingListNormal = adapterMatchingListNormal;
            this.rvmatchinquestion1.setAdapter(adapterMatchingListNormal);
            this.adapterMatchingListDrag.setOnItemClickListener(new AdapterMatchingListDrag.OnItemClickListener() { // from class: com.appnew.android.Webview.RevisionSC_TestSeriesFragment.2
                @Override // com.appnew.android.testmodule.adapter.AdapterMatchingListDrag.OnItemClickListener
                public void onItemClick(View view, Social obj, int p, int bg, int circle, boolean select) {
                    if (select) {
                        RevisionSC_TestSeriesFragment.this.selected.add(new mcSelection(p, bg, circle, select));
                        ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).setSelcted(RevisionSC_TestSeriesFragment.this.selected);
                        ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).setIsanswer(true, RevisionSC_TestSeriesFragment.this.selectedAnswerposition + 1, RevisionSC_TestSeriesFragment.this.tags);
                    } else {
                        int i13 = 0;
                        while (true) {
                            if (i13 >= ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().size()) {
                                break;
                            }
                            if (((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().get(i13).getPosition() == p) {
                                ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().remove(i13);
                                break;
                            }
                            i13++;
                        }
                    }
                    boolean z = false;
                    for (int i14 = 0; i14 < ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().size(); i14++) {
                        if (((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().get(i14).isSelect()) {
                            z = true;
                        }
                    }
                    if (z) {
                        RevisionSC_TestSeriesFragment.this.tags.clear();
                        for (int i15 = 0; i15 < ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).items1.size(); i15++) {
                            int i16 = 0;
                            while (true) {
                                if (i16 >= ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().size()) {
                                    break;
                                }
                                if (!((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().get(i16).isSelect()) {
                                    RevisionSC_TestSeriesFragment.this.tags.add(i15, 0);
                                    break;
                                }
                                int i17 = 0;
                                while (true) {
                                    if (i17 < RevisionTest.SAMPLE_CIRCLE.length) {
                                        int circlecolor_code = ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().get(i16).getCirclecolor_code();
                                        if (circlecolor_code == RevisionTest.SAMPLE_CIRCLE[i17]) {
                                            RevisionSC_TestSeriesFragment.this.tags.add(Integer.valueOf(((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().get(i16).getPosition() + 1));
                                            break;
                                        }
                                        i17++;
                                    }
                                }
                                i16++;
                            }
                        }
                        ((RevisionTest) RevisionSC_TestSeriesFragment.this.activity).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).setIsanswer(true, 1, RevisionSC_TestSeriesFragment.this.tags);
                        return;
                    }
                    ((RevisionTest) RevisionSC_TestSeriesFragment.this.activity).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).setIsanswer(false, 0);
                }
            });
            this.adapterMatchingListDrag.setMachingOnDrag(new AdapterMatchingListDrag.MachingOnDrag() { // from class: com.appnew.android.Webview.RevisionSC_TestSeriesFragment.3
                @Override // com.appnew.android.testmodule.adapter.AdapterMatchingListDrag.MachingOnDrag
                public void sendOnclickInd(int p) {
                    if (RevisionSC_TestSeriesFragment.this.adapterMatchingListNormal != null) {
                        int i13 = 0;
                        while (true) {
                            if (i13 >= ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted2().size()) {
                                break;
                            }
                            if (((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted2().get(i13).getPosition() == p) {
                                ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted2().remove(i13);
                                break;
                            }
                            i13++;
                        }
                        RevisionSC_TestSeriesFragment.this.adapterMatchingListNormal.notifyDataSetChanged();
                    }
                }
            });
            this.adapterMatchingListNormal.setMachingOnDrag(new AdapterMatchingListNormal.MachingOnDrag() { // from class: com.appnew.android.Webview.RevisionSC_TestSeriesFragment.4
                @Override // com.appnew.android.testmodule.adapter.AdapterMatchingListNormal.MachingOnDrag
                public void sendOnclickInd(int p) {
                    ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().remove(p);
                    if (((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted().size() == 0) {
                        RevisionTest.nestselected = false;
                    }
                    RevisionTest.sameselected = false;
                    RevisionSC_TestSeriesFragment.this.adapterMatchingListDrag.notifyDataSetChanged();
                }
            });
            this.adapterMatchingListNormal.setOnItemClickListener(new AdapterMatchingListNormal.OnItemClickListener() { // from class: com.appnew.android.Webview.RevisionSC_TestSeriesFragment.5
                @Override // com.appnew.android.testmodule.adapter.AdapterMatchingListNormal.OnItemClickListener
                public void onItemClick(View view, int p, Social obj, int bg, int circle, boolean select) {
                    if (select) {
                        RevisionSC_TestSeriesFragment.this.selected2.add(new mcSelection(p, bg, circle, select));
                        ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).setSelcted2(RevisionSC_TestSeriesFragment.this.selected2);
                        return;
                    }
                    for (int i13 = 0; i13 < ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted2().size(); i13++) {
                        if (((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted2().get(i13).getPosition() == p) {
                            ((RevisionTest) RevisionSC_TestSeriesFragment.this.getActivity()).questionBankList.get(RevisionSC_TestSeriesFragment.this.position).getSelcted2().remove(i13);
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
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.layout_option_test_view_revision, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.optionIconTV);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.optionTextTV);
        RadioButton radioButton = (RadioButton) linearLayout.findViewById(R.id.radioRB);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.imgOption);
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
        if (str2.contains("<img src=")) {
            imageView.setVisibility(0);
            Matcher matcher = Pattern.compile("(?i)<img[^>]+?src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>").matcher(str2);
            while (matcher.find()) {
                Glide.with(this.activity).load(matcher.group(1)).into(imageView);
            }
        } else {
            textView2.setVisibility(0);
            imageView.setVisibility(8);
            str2.trim();
            textView2.setText(str2.replaceAll("\\<.*?\\>", ""));
        }
        String str4 = this.questionType;
        int iHashCode = str4.hashCode();
        if (iHashCode != 2454) {
            if (iHashCode != 2640) {
                if (iHashCode != 2674) {
                    if (iHashCode == 69599) {
                        str4.equals("FIB");
                    }
                } else if (str4.equals("TF") && ((RevisionTest) getActivity()).questionBankList.get(this.position).isanswer() && ((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() != 0 && ((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() - 1 == i) {
                    linearLayout.setSelected(true);
                }
            } else if (str4.equals("SC") && ((RevisionTest) getActivity()).questionBankList.get(this.position).isanswer() && ((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() != 0 && ((RevisionTest) getActivity()).questionBankList.get(this.position).getAnswerPosttion() - 1 == i) {
                linearLayout.setSelected(true);
            }
        } else if (str4.equals("MC") && ((RevisionTest) this.activity).questionBankList.get(this.position).getSelectedValue() != null && ((RevisionTest) this.activity).questionBankList.get(this.position).getSelectedValue().contains(Integer.valueOf(i))) {
            linearLayout.setSelected(true);
            this.selectedValue = ((RevisionTest) this.activity).questionBankList.get(this.position).getSelectedValue();
        }
        this.LinearLayoutList.add(linearLayout);
        this.parentList.add(this.parentLL);
        this.tvList.add(textView);
        linearLayout.setOnClickListener(this.onClickListener);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkBox /* 2131362544 */:
                if (((CompoundButton) view).isChecked()) {
                    System.out.println("Checked");
                    this.guess = "1";
                    ((RevisionTest) getActivity()).questionBankList.get(this.position).setIsguess(this.guess);
                } else {
                    this.guess = "0";
                    ((RevisionTest) getActivity()).questionBankList.get(this.position).setIsguess(this.guess);
                }
                break;
            case R.id.mark_for_review /* 2131364196 */:
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.marked_for_review), 0).show();
                ((RevisionTest) getActivity()).questionBankList.get(this.position).setMarkForReview(true);
                ((RevisionTest) getActivity()).questionBankList.get(this.position).setIssaveMarkForReview(false);
                ((RevisionTest) getActivity()).notifynumberApater();
                this.markForReview.setVisibility(8);
                this.unmarkForReview.setVisibility(0);
                break;
            case R.id.remove_mark_for_review /* 2131365044 */:
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.remove_amp_marked_for_review), 0).show();
                ((RevisionTest) getActivity()).questionBankList.get(this.position).setIssaveMarkForReview(false);
                ((RevisionTest) getActivity()).notifynumberApater();
                break;
            case R.id.save_mark_for_review /* 2131365228 */:
                if (((RevisionTest) getActivity()).questionBankList.get(this.position).isanswer()) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.save_and_marked_for_review), 0).show();
                    ((RevisionTest) getActivity()).questionBankList.get(this.position).setIssaveMarkForReview(true);
                    ((RevisionTest) getActivity()).questionBankList.get(this.position).setMarkForReview(false);
                    ((RevisionTest) getActivity()).notifynumberApater();
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
                ((RevisionTest) getActivity()).questionBankList.get(this.position).setMarkForReview(false);
                ((RevisionTest) getActivity()).notifynumberApater();
                this.markForReview.setVisibility(0);
                this.unmarkForReview.setVisibility(8);
                break;
        }
    }

    public void refereshPage() {
        if (this.questionType.equalsIgnoreCase("MT")) {
            for (int i = 0; i < ((RevisionTest) getActivity()).questionBankList.get(this.position).getSelcted().size(); i++) {
                if (((RevisionTest) getActivity()).questionBankList.get(this.position).getSelcted().get(i).isSelect()) {
                    ((RevisionTest) getActivity()).questionBankList.get(this.position).getSelcted().clear();
                }
            }
            this.adapterMatchingListDrag.notifyDataSetChanged();
            for (int i2 = 0; i2 < ((RevisionTest) getActivity()).questionBankList.get(this.position).getSelcted2().size(); i2++) {
                ((RevisionTest) getActivity()).questionBankList.get(this.position).getSelcted2().clear();
            }
            this.adapterMatchingListNormal.notifyDataSetChanged();
            return;
        }
        ((RevisionTest) getActivity()).questionBankList.get(this.position).setIsanswer(false, 0);
        this.checkBoxGuess.setChecked(false);
        this.guess = "0";
        for (int i3 = 0; i3 < this.LinearLayoutList.size(); i3++) {
            this.LinearLayoutList.get(i3).setSelected(false);
        }
    }

    @Override // com.appnew.android.testmodule.interfaces.MachingOnDrag
    public void sendOnclickInd(int p) {
        if (this.adapterMatchingListNormal != null) {
            int i = 0;
            while (true) {
                if (i >= ((RevisionTest) getActivity()).questionBankList.get(this.position).getSelcted2().size()) {
                    break;
                }
                if (((RevisionTest) getActivity()).questionBankList.get(this.position).getSelcted2().get(i).getPosition() == p) {
                    ((RevisionTest) getActivity()).questionBankList.get(this.position).getSelcted2().remove(i);
                    break;
                }
                i++;
            }
            this.adapterMatchingListNormal.notifyDataSetChanged();
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
                this.mDrawable.setBounds(0, 0, RevisionSC_TestSeriesFragment.this.empty.getIntrinsicWidth(), RevisionSC_TestSeriesFragment.this.empty.getIntrinsicHeight());
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
            webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.Webview.RevisionSC_TestSeriesFragment.6
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
}
