package com.appnew.android.testmodule.fragment;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
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
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class FIB_TestSeriesFragment extends MainFragment implements View.OnClickListener, Html.ImageGetter {
    LinearLayout LLFIBquestion;
    List<View> LinearLayoutList;
    private CheckBox checkBoxGuess;
    private Drawable empty;
    LinearLayout explanationLL;
    TextView explanationTV;
    FIB_Adapter fib_adapter;
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
    LinearLayout parentLL;
    List<View> parentList;
    private TextView pos_mark;
    int position;
    private Question questionBank;
    RelativeLayout question_layout1;
    private TextView remove_mark_for_review;
    RecyclerView rvfibquestion;
    private TextView save_mark_for_review;
    private boolean status;
    private TextView tvEmail;
    List<View> tvList;
    ClickableWebView tvQuestion;
    ClickableWebView tvQuestionFib;
    private TextView tvReportError;
    private TextView tv_timer;
    private TextView tv_uid;
    private TextView unmarkForReview;
    int count = 0;
    List<FIBEdit> fibEdits = new ArrayList();
    int selectedAnswerposition = -1;
    ArrayList<Integer> selectedValue = new ArrayList<>();
    ArrayList<String> selectedValue1 = new ArrayList<>();
    ArrayList<TextView> textViews = new ArrayList<>();
    ArrayList tags = new ArrayList();
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.FIB_TestSeriesFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((TestBaseActivity) FIB_TestSeriesFragment.this.activity).isOptionCountExceed(FIB_TestSeriesFragment.this.position)) {
                Toast.makeText(FIB_TestSeriesFragment.this.activity, "You can attempt only " + ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).getSectionOptionalCount(FIB_TestSeriesFragment.this.position) + " optional questions", 0).show();
                return;
            }
            FIB_TestSeriesFragment.this.selectedAnswerposition = ((Integer) view.getTag()).intValue();
            ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).getAnswer().split(Constants.SEPARATOR_COMMA);
            if (FIB_TestSeriesFragment.this.LinearLayoutList.get(FIB_TestSeriesFragment.this.selectedAnswerposition).isSelected()) {
                int i = 0;
                while (true) {
                    if (i >= FIB_TestSeriesFragment.this.selectedValue.size()) {
                        break;
                    }
                    if (FIB_TestSeriesFragment.this.selectedAnswerposition == FIB_TestSeriesFragment.this.selectedValue.get(i).intValue()) {
                        FIB_TestSeriesFragment.this.selectedValue.remove(i);
                        FIB_TestSeriesFragment.this.selectedValue1.remove(i);
                        String type = FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getType();
                        type.hashCode();
                        if (type.equals(CTVariableUtils.NUMBER)) {
                            FIB_TestSeriesFragment fIB_TestSeriesFragment = FIB_TestSeriesFragment.this;
                            fIB_TestSeriesFragment.showEnterData(fIB_TestSeriesFragment.textViews.get(FIB_TestSeriesFragment.this.selectedAnswerposition), FIB_TestSeriesFragment.this.textViews.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getText().toString(), FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getType(), "", "");
                        } else {
                            FIB_TestSeriesFragment fIB_TestSeriesFragment2 = FIB_TestSeriesFragment.this;
                            fIB_TestSeriesFragment2.showEnterData(fIB_TestSeriesFragment2.textViews.get(FIB_TestSeriesFragment.this.selectedAnswerposition), FIB_TestSeriesFragment.this.textViews.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getText().toString(), FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getType(), FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getMax(), FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getMin());
                        }
                    } else {
                        i++;
                    }
                }
            } else {
                String type2 = FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getType();
                type2.hashCode();
                if (type2.equals(CTVariableUtils.NUMBER)) {
                    FIB_TestSeriesFragment fIB_TestSeriesFragment3 = FIB_TestSeriesFragment.this;
                    fIB_TestSeriesFragment3.showEnterData(fIB_TestSeriesFragment3.textViews.get(FIB_TestSeriesFragment.this.selectedAnswerposition), "", FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getType(), "", "");
                } else {
                    FIB_TestSeriesFragment fIB_TestSeriesFragment4 = FIB_TestSeriesFragment.this;
                    fIB_TestSeriesFragment4.showEnterData(fIB_TestSeriesFragment4.textViews.get(FIB_TestSeriesFragment.this.selectedAnswerposition), "", FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getType(), FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getMax(), FIB_TestSeriesFragment.this.fibEdits.get(FIB_TestSeriesFragment.this.selectedAnswerposition).getMin());
                }
            }
            for (int i2 = 0; i2 < FIB_TestSeriesFragment.this.LinearLayoutList.size(); i2++) {
                if (FIB_TestSeriesFragment.this.LinearLayoutList.get(i2).isSelected()) {
                    String str = "";
                    for (int i3 = 0; i3 < ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).getSelectedValue().size(); i3++) {
                        str = str + ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).getSelectedValue().get(i3) + Constants.SEPARATOR_COMMA;
                    }
                    FIB_TestSeriesFragment.this.tags.clear();
                    for (int i4 = 0; i4 < FIB_TestSeriesFragment.this.LinearLayoutList.size(); i4++) {
                        if (str.contains(String.valueOf(i4))) {
                            FIB_TestSeriesFragment.this.tags.add("1");
                        } else {
                            FIB_TestSeriesFragment.this.tags.add("0");
                        }
                    }
                    if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).questionDumpList.size() > 0) {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList2.get(FIB_TestSeriesFragment.this.position).setIsanswer(true, FIB_TestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_TestSeriesFragment.this.selectedValue1);
                        return;
                    } else {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).setIsanswer(true, FIB_TestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_TestSeriesFragment.this.selectedValue1);
                        return;
                    }
                }
            }
            if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).questionDumpList.size() > 0) {
                ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList2.get(FIB_TestSeriesFragment.this.position).setIsanswer(false, 0);
            } else {
                ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).setIsanswer(false, 0);
            }
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

    public static FIB_TestSeriesFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.POSITION, position);
        FIB_TestSeriesFragment fIB_TestSeriesFragment = new FIB_TestSeriesFragment();
        fIB_TestSeriesFragment.setArguments(bundle);
        return fIB_TestSeriesFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_series, (ViewGroup) null);
        this.activity = getActivity();
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
        if (!TextUtils.isEmpty(min)) {
            min = min.replaceAll("[^0-9-]", "");
        }
        if (!TextUtils.isEmpty(max)) {
            max = max.replaceAll("[^0-9-]", "");
        }
        if (!TextUtils.isEmpty(min) && !min.equalsIgnoreCase("undefined") && min.trim().matches("-?\\d+")) {
            try {
                editText.setMinLines(Integer.parseInt(min.trim()));
            } catch (NumberFormatException unused) {
            }
        }
        if (!TextUtils.isEmpty(max) && !max.equalsIgnoreCase("undefined") && max.trim().matches("-?\\d+")) {
            try {
                editText.setMaxLines(Integer.parseInt(max.trim()));
            } catch (NumberFormatException unused2) {
            }
        }
        if (!messege.equalsIgnoreCase("")) {
            editText.setText(messege);
        } else {
            editText.setHint("Enter Answer");
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.FIB_TestSeriesFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(FIB_TestSeriesFragment.this.activity, FIB_TestSeriesFragment.this.activity.getResources().getString(R.string.please_enter_answer), 0).show();
                    return;
                }
                dialog.dismiss();
                if (!TextUtils.isEmpty(editText.getText())) {
                    textView.setText(editText.getText().toString());
                    FIB_TestSeriesFragment.this.LinearLayoutList.get(FIB_TestSeriesFragment.this.selectedAnswerposition).setSelected(true);
                    FIB_TestSeriesFragment.this.selectedValue.add(FIB_TestSeriesFragment.this.selectedAnswerposition, Integer.valueOf(FIB_TestSeriesFragment.this.selectedAnswerposition));
                    FIB_TestSeriesFragment.this.selectedValue1.add(FIB_TestSeriesFragment.this.selectedAnswerposition, editText.getText().toString());
                    if (FIB_TestSeriesFragment.this.selectedValue1.size() > 0 && FIB_TestSeriesFragment.this.selectedValue1.size() == 3) {
                        if (FIB_TestSeriesFragment.this.selectedValue1.get(2).equalsIgnoreCase("")) {
                            FIB_TestSeriesFragment.this.selectedValue1.remove(2);
                            FIB_TestSeriesFragment.this.selectedValue.remove(2);
                        } else if (FIB_TestSeriesFragment.this.selectedValue1.get(1).equalsIgnoreCase("")) {
                            FIB_TestSeriesFragment.this.selectedValue1.remove(1);
                            FIB_TestSeriesFragment.this.selectedValue.remove(1);
                        }
                    }
                    if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).questionDumpList.size() > 0) {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList2.get(FIB_TestSeriesFragment.this.position).setSelectedValue(FIB_TestSeriesFragment.this.selectedValue);
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList2.get(FIB_TestSeriesFragment.this.position).setSelectedString(FIB_TestSeriesFragment.this.selectedValue1);
                    } else {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).setSelectedValue(FIB_TestSeriesFragment.this.selectedValue);
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).setSelectedString(FIB_TestSeriesFragment.this.selectedValue1);
                    }
                    if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(FIB_TestSeriesFragment.this.position).setSelectedValue(FIB_TestSeriesFragment.this.selectedValue);
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).data.getQuestionsHindi().get(FIB_TestSeriesFragment.this.position).setSelectedString(FIB_TestSeriesFragment.this.selectedValue1);
                    } else if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(FIB_TestSeriesFragment.this.position).setSelectedValue(FIB_TestSeriesFragment.this.selectedValue);
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).data.getQuestions().get(FIB_TestSeriesFragment.this.position).setSelectedString(FIB_TestSeriesFragment.this.selectedValue1);
                    }
                } else {
                    textView.setText(FIB_TestSeriesFragment.this.activity.getResources().getString(R.string.enter_answer_));
                    FIB_TestSeriesFragment.this.LinearLayoutList.get(FIB_TestSeriesFragment.this.selectedAnswerposition).setSelected(false);
                    if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).questionDumpList.size() > 0) {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList2.get(FIB_TestSeriesFragment.this.position).setSelectedString(FIB_TestSeriesFragment.this.selectedValue1);
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList2.get(FIB_TestSeriesFragment.this.position).setSelectedValue(FIB_TestSeriesFragment.this.selectedValue);
                    } else {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).setSelectedString(FIB_TestSeriesFragment.this.selectedValue1);
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).setSelectedValue(FIB_TestSeriesFragment.this.selectedValue);
                    }
                    if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(FIB_TestSeriesFragment.this.position).setSelectedValue(FIB_TestSeriesFragment.this.selectedValue);
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).data.getQuestionsHindi().get(FIB_TestSeriesFragment.this.position).setSelectedString(FIB_TestSeriesFragment.this.selectedValue1);
                    } else if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(FIB_TestSeriesFragment.this.position).setSelectedValue(FIB_TestSeriesFragment.this.selectedValue);
                        ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).data.getQuestions().get(FIB_TestSeriesFragment.this.position).setSelectedString(FIB_TestSeriesFragment.this.selectedValue1);
                    }
                }
                for (int i = 0; i < FIB_TestSeriesFragment.this.LinearLayoutList.size(); i++) {
                    if (FIB_TestSeriesFragment.this.LinearLayoutList.get(i).isSelected()) {
                        String str = "";
                        for (int i2 = 0; i2 < ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).getSelectedValue().size(); i2++) {
                            str = str + ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).getSelectedValue().get(i2) + Constants.SEPARATOR_COMMA;
                        }
                        if (str.startsWith("1")) {
                            str = "0," + str;
                            FIB_TestSeriesFragment.this.selectedValue1.add(0, "");
                        }
                        if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).questionDumpList.size() > 0) {
                            ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList2.get(FIB_TestSeriesFragment.this.position).setIsanswer(true, FIB_TestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_TestSeriesFragment.this.selectedValue1);
                        } else {
                            ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).setIsanswer(true, FIB_TestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_TestSeriesFragment.this.selectedValue1);
                        }
                        if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("H/E")) {
                            ((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(FIB_TestSeriesFragment.this.position).setIsanswer(true, FIB_TestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_TestSeriesFragment.this.selectedValue1);
                            return;
                        } else {
                            if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("E/H")) {
                                ((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(FIB_TestSeriesFragment.this.position).setIsanswer(true, FIB_TestSeriesFragment.this.selectedAnswerposition + 1, str, FIB_TestSeriesFragment.this.selectedValue1);
                                return;
                            }
                            return;
                        }
                    }
                }
                if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).questionDumpList.size() > 0) {
                    ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList2.get(FIB_TestSeriesFragment.this.position).setIsanswer(false, 0);
                } else {
                    ((TestBaseActivity) FIB_TestSeriesFragment.this.activity).questionBankList.get(FIB_TestSeriesFragment.this.position).setIsanswer(false, 0);
                }
                if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("H/E")) {
                    ((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).data.getQuestionsHindi().get(FIB_TestSeriesFragment.this.position).setIsanswer(false, 0);
                } else if (((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).changelang.getText().equals("E/H")) {
                    ((TestBaseActivity) FIB_TestSeriesFragment.this.requireActivity()).data.getQuestions().get(FIB_TestSeriesFragment.this.position).setIsanswer(false, 0);
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
            if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
                ((TestBaseActivity) this.activity).questionBankList2.get(this.position).setIsanswer(false, 0);
            } else {
                ((TestBaseActivity) this.activity).questionBankList.get(this.position).setIsanswer(false, 0);
            }
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                ((TestBaseActivity) this.activity).data.getQuestionsHindi().get(this.position).setIsanswer(false, 0);
            } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                ((TestBaseActivity) this.activity).data.getQuestions().get(this.position).setIsanswer(false, 0);
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                if (((TestBaseActivity) requireActivity()).data.getQuestionsHindi() != null && ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().size() > 0) {
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setAnspositions("-1");
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setSelectedValue(arrayList);
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setSelectedString(arrayList2);
                    ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setAnswers(arrayList3);
                }
            } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H") && ((TestBaseActivity) requireActivity()).data.getQuestions() != null && ((TestBaseActivity) requireActivity()).data.getQuestions().size() > 0) {
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setAnspositions("-1");
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setSelectedValue(arrayList);
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setSelectedString(arrayList2);
                ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setAnswers(arrayList3);
            }
            if (((TestBaseActivity) requireActivity()).questionDumpList.size() > 0) {
                ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setAnspositions("-1");
                ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setSelectedValue(arrayList);
                ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setSelectedString(arrayList2);
                ((TestBaseActivity) requireActivity()).questionBankList2.get(this.position).setAnswers(arrayList3);
            } else {
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setAnspositions("-1");
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setSelectedValue(arrayList);
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setSelectedString(arrayList2);
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setAnswers(arrayList3);
            }
            this.checkBoxGuess.setChecked(false);
            this.guess = "0";
            for (int i = 0; i < this.LinearLayoutList.size(); i++) {
                this.LinearLayoutList.get(i).setSelected(false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (SharedPreference.getInstance().getString("const val") == null || TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
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
        String strReplace;
        this.mcqoptionsLL = (LinearLayout) view.findViewById(R.id.mcqoptions);
        this.tvQuestion = (ClickableWebView) view.findViewById(R.id.tv_question);
        this.question_layout1 = (RelativeLayout) view.findViewById(R.id.question_layout1);
        this.tvQuestionFib = (ClickableWebView) view.findViewById(R.id.tv_question_fib);
        this.imgBookmark = (ImageView) view.findViewById(R.id.img_bookmark);
        this.checkBoxGuess = (CheckBox) view.findViewById(R.id.checkBox);
        this.LLFIBquestion = (LinearLayout) view.findViewById(R.id.LLFIBquestion);
        this.rvfibquestion = (RecyclerView) view.findViewById(R.id.rvfibquestion1);
        this.markForReview = (TextView) view.findViewById(R.id.mark_for_review);
        this.unmarkForReview = (TextView) view.findViewById(R.id.unmark_for_review);
        this.save_mark_for_review = (TextView) view.findViewById(R.id.save_mark_for_review);
        this.remove_mark_for_review = (TextView) view.findViewById(R.id.remove_mark_for_review);
        this.tvReportError = (TextView) view.findViewById(R.id.tv_report_error);
        this.tv_uid = (TextView) view.findViewById(R.id.tv_uid);
        this.tvEmail = (TextView) view.findViewById(R.id.tv_email);
        this.explanationLL = (LinearLayout) view.findViewById(R.id.explanationLL);
        this.explanationTV = (TextView) view.findViewById(R.id.explanationTV);
        this.nestedSV = (NestedScrollView) view.findViewById(R.id.nestedSV);
        this.llTimerNegPos = (LinearLayout) view.findViewById(R.id.llTimerNegPos);
        this.tv_timer = (TextView) view.findViewById(R.id.tv_timer);
        this.pos_mark = (TextView) view.findViewById(R.id.pos_mark);
        this.neg_mark = (TextView) view.findViewById(R.id.neg_mark);
        this.mandatoryType = (TextView) view.findViewById(R.id.mandatoryType);
        this.multiple_choice_instruction = (TextView) view.findViewById(R.id.multiple_choice_instruction);
        this.LinearLayoutList = new ArrayList();
        this.parentList = new ArrayList();
        this.tvList = new ArrayList();
        this.llTimerNegPos.setVisibility(0);
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
        this.questionBank = ((TestBaseActivity) requireActivity()).questionBankList.get(this.position);
        String question = ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getQuestion();
        this.tv_uid.setText(this.activity.getResources().getString(R.string.question_id) + this.questionBank.getId());
        this.mcqoptionsLL.setVisibility(0);
        this.LLFIBquestion.setVisibility(8);
        if (SharedPreference.getInstance().getString(Const.HIDE_FIB).equalsIgnoreCase("1")) {
            strReplace = question.replace("FIB", "");
        } else {
            strReplace = question.replace("FIB", ".....");
        }
        this.tvQuestion.setBackgroundColor(0);
        this.tvQuestion.setLayerType(2, null);
        this.tvQuestion.getSettings().setJavaScriptEnabled(true);
        this.tvQuestion.getSettings().setGeolocationEnabled(true);
        if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type().equalsIgnoreCase("1") || ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type().equalsIgnoreCase("2")) {
            Helper.testQuestionFont(this.tvQuestion, this.position, question, ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getFont_type());
        } else {
            Helper.TestWebHTMLLoad(this.tvQuestion, Helper.getHTMLWidthForImage("<p style='font-family:sans-serif !important; font-size:16px; margin:0;'>Q-" + (this.position + 1) + ".</p>" + strReplace));
        }
        this.tvQuestion.setLongClickable(false);
        this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.question_layout1));
        if (TextUtils.isEmpty(((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getParagraphText())) {
            this.tvQuestionFib.setVisibility(8);
        } else {
            this.tvQuestionFib.setVisibility(0);
            Helper.TestWebHTMLLoad(this.tvQuestionFib, ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getParagraphText());
        }
        addQuestionOption();
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
        this.unmarkForReview.setOnClickListener(this);
        this.remove_mark_for_review.setOnClickListener(this);
        this.save_mark_for_review.setOnClickListener(this);
        this.tvReportError.setOnClickListener(this);
        if (SharedPreference.getInstance().getString(Const.BOOK_MARK) != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.BOOK_MARK)) && SharedPreference.getInstance().getString(Const.BOOK_MARK).equalsIgnoreCase("1")) {
            this.imgBookmark.setVisibility(0);
        } else {
            this.imgBookmark.setVisibility(8);
        }
        if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getIs_bookmarked().equals("1")) {
            this.imgBookmark.setImageResource(R.mipmap.bookmark_selected);
        } else {
            this.imgBookmark.setImageResource(R.mipmap.bookmark_unselected);
        }
        if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getIsguess().equals("1")) {
            this.checkBoxGuess.setChecked(true);
        } else {
            this.checkBoxGuess.setChecked(false);
        }
        this.tvEmail.setText(((TestBaseActivity) requireActivity()).data.getUserDetails().getEmail());
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
        if (((TestBaseActivity) requireActivity()).questionBankList2 != null && ((TestBaseActivity) requireActivity()).questionBankList2.size() > 0) {
            if (((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedValue() != null) {
                if (((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedValue().contains(Integer.valueOf(i))) {
                    if (((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedString() == null || ((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedString().isEmpty() || TextUtils.isEmpty(((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedString().get(i))) {
                        this.selectedValue1.add("");
                        textView2.setText(this.activity.getResources().getString(R.string.enter_answer_for) + str + " )");
                    } else {
                        linearLayout.setSelected(true);
                        textView2.setText(((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedString().get(i));
                        this.selectedValue1.add(((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedString().get(i));
                        this.selectedValue = ((TestBaseActivity) this.activity).questionBankList2.get(this.position).getSelectedValue();
                    }
                } else {
                    textView2.setText(this.activity.getResources().getString(R.string.enter_answer_for) + str + " )");
                    this.selectedValue.add(0);
                    this.selectedValue1.add("");
                }
            }
        } else if (((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedValue() != null) {
            if (((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedValue().contains(Integer.valueOf(i))) {
                if (((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedString() == null || ((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedString().isEmpty() || TextUtils.isEmpty(((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedString().get(i))) {
                    this.selectedValue1.add("");
                    textView2.setText(this.activity.getResources().getString(R.string.enter_answer_for) + str + " )");
                } else {
                    linearLayout.setSelected(true);
                    textView2.setText(((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedString().get(i));
                    this.selectedValue1.add(((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedString().get(i));
                    this.selectedValue = ((TestBaseActivity) this.activity).questionBankList.get(this.position).getSelectedValue();
                }
            } else {
                textView2.setText(this.activity.getResources().getString(R.string.enter_answer_for) + str + " )");
                this.selectedValue.add(0);
                this.selectedValue1.add("");
            }
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
                if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).getIs_bookmarked().equals("1")) {
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIs_bookmarked("0");
                    this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_unselected));
                    if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIs_bookmarked("0");
                    } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIs_bookmarked("0");
                    }
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.unboomark), 0).show();
                } else {
                    ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIs_bookmarked("1");
                    this.imgBookmark.setImageDrawable(this.activity.getResources().getDrawable(R.mipmap.bookmark_selected));
                    if (((TestBaseActivity) requireActivity()).changelang.getText().equals("H/E")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestionsHindi().get(this.position).setIs_bookmarked("1");
                    } else if (((TestBaseActivity) requireActivity()).changelang.getText().equals("E/H")) {
                        ((TestBaseActivity) requireActivity()).data.getQuestions().get(this.position).setIs_bookmarked("1");
                    }
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.boomark), 0).show();
                }
                break;
            case R.id.mark_for_review /* 2131364196 */:
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.marked_for_review), 0).show();
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setMarkForReview(true);
                ((TestBaseActivity) requireActivity()).questionBankList.get(this.position).setIssaveMarkForReview(false);
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
                    Toast.makeText(this.activity, R.string.save_and_marked_for_review, 0).show();
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
                this.mDrawable.setBounds(0, 0, FIB_TestSeriesFragment.this.empty.getIntrinsicWidth(), FIB_TestSeriesFragment.this.empty.getIntrinsicHeight());
                this.mDrawable.setLevel(1);
            }
        }
    }

    public void setMarkForReviewStatus() {
        if (((TestBaseActivity) requireActivity()).questionBankList.get(this.position).isMarkForReview()) {
            this.markForReview.setVisibility(8);
            this.unmarkForReview.setVisibility(0);
        } else {
            this.markForReview.setVisibility(0);
            this.unmarkForReview.setVisibility(8);
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
