package com.appnew.android.CreateTest.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import com.appnew.android.CreateTest.Activity.TestCreateActivity;
import com.appnew.android.CreateTest.Model.CreateTestQuesData;
import com.appnew.android.CreateTest.Model.CreateTestSubject;
import com.appnew.android.CreateTest.Model.QuestionCount;
import com.appnew.android.CreateTest.Model.QuestionCountData;
import com.appnew.android.CreateTest.Model.TypeTest;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.testmodule.model.Data;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodule.model.Questions2;
import com.appnew.android.testmodule.model.TestBasic;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CreateTestFragmentThree extends MainFragment implements PopupMenu.OnMenuItemClickListener, View.OnClickListener {
    Activity activity;
    BottomSheetDialog bottomSheetDialog;
    Button buttonProceed;
    ImageView downarrowIV;
    String enterQues;
    EditText et_max;
    String frag_type;
    TextView highTV;
    TextView lowTV;
    TextView maxTV;
    TextView mediumTV;
    RelativeLayout parentLL;
    QuestionCount questionCount;
    RelativeLayout spinnerLL;
    int totalQues;
    TextView totalquestion;
    TextView typeSpinner;
    String subjectIds = "";
    String LANG = "";
    String type = "0";
    String type_total_question = "0";
    ArrayList<CreateTestSubject> createTestSubjects = new ArrayList<>();

    public static CreateTestFragmentThree newInstance(String frag_type, ArrayList<CreateTestSubject> createTestSubjects, String lang) {
        CreateTestFragmentThree createTestFragmentThree = new CreateTestFragmentThree();
        Bundle bundle = new Bundle();
        bundle.putString(Const.FRAG_TYPE, frag_type);
        bundle.putString(Const.LANG, lang);
        bundle.putSerializable(Const.CREATE_COURSE_SUBJECT_DATA, createTestSubjects);
        createTestFragmentThree.setArguments(bundle);
        return createTestFragmentThree;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.LANG = getArguments().getString(Const.LANG);
            this.createTestSubjects = (ArrayList) getArguments().getSerializable(Const.CREATE_COURSE_SUBJECT_DATA);
            ArrayList arrayList = new ArrayList();
            Iterator<CreateTestSubject> it = this.createTestSubjects.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getId());
            }
            this.subjectIds = TextUtils.join(Constants.SEPARATOR_COMMA, arrayList);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        this.spinnerLL.setOnClickListener(this);
        this.downarrowIV.setOnClickListener(this);
        this.typeSpinner.setOnClickListener(this);
        this.buttonProceed.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentThree.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CreateTestFragmentThree.this.CheckValidation();
            }
        });
    }

    public void CheckValidation() {
        if (Helper.isNetworkConnected(this.activity)) {
            if (this.questionCount != null) {
                this.enterQues = this.et_max.getText().toString().trim();
                if (this.typeSpinner.getText().toString().equalsIgnoreCase("Type")) {
                    Activity activity = this.activity;
                    Toast.makeText(activity, activity.getResources().getString(R.string.please_select_test_type), 0).show();
                    return;
                }
                if (TextUtils.isEmpty(this.enterQues) || this.enterQues.equalsIgnoreCase("0") || this.enterQues.equalsIgnoreCase("00") || this.enterQues.equalsIgnoreCase("000")) {
                    Activity activity2 = this.activity;
                    Toast.makeText(activity2, activity2.getResources().getString(R.string.question_count_should_be_1_to_100), 0).show();
                    return;
                }
                if (Integer.parseInt(this.enterQues) > 100) {
                    Activity activity3 = this.activity;
                    Toast.makeText(activity3, activity3.getResources().getString(R.string.question_count_should_be_less_then__100), 0).show();
                    return;
                }
                if (this.typeSpinner.getText().toString().equalsIgnoreCase("Low") && Integer.parseInt(this.enterQues) > Integer.parseInt(this.questionCount.getEasy())) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.low_question_count_should_be_max) + Integer.parseInt(this.questionCount.getEasy()), 0).show();
                    return;
                }
                if (this.typeSpinner.getText().toString().equalsIgnoreCase("Medium") && Integer.parseInt(this.enterQues) > Integer.parseInt(this.questionCount.getMedium())) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.medium_queston_count_should_be_max) + Integer.parseInt(this.questionCount.getMedium()), 0).show();
                    return;
                } else if (this.typeSpinner.getText().toString().equalsIgnoreCase("High") && Integer.parseInt(this.enterQues) > Integer.parseInt(this.questionCount.getHard())) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.high_queston_count_should_be_max) + Integer.parseInt(this.questionCount.getHard()), 0).show();
                    return;
                } else {
                    createTestDialog();
                    NetworkAPICall(API.API_CREATE_TEST_GET_TEST, "", false, false, false);
                    return;
                }
            }
            return;
        }
        Activity activity4 = this.activity;
        Toast.makeText(activity4, activity4.getResources().getString(R.string.check_your_internet_connection_and_try_again), 0).show();
    }

    private void initView(View view) {
        this.parentLL = (RelativeLayout) view.findViewById(R.id.parentLL);
        this.spinnerLL = (RelativeLayout) view.findViewById(R.id.spinnerLL);
        this.totalquestion = (TextView) view.findViewById(R.id.totalquestion);
        this.lowTV = (TextView) view.findViewById(R.id.lowTV);
        this.mediumTV = (TextView) view.findViewById(R.id.mediumTV);
        this.highTV = (TextView) view.findViewById(R.id.highTV);
        this.maxTV = (TextView) view.findViewById(R.id.maxTV);
        this.et_max = (EditText) view.findViewById(R.id.et_max);
        this.typeSpinner = (TextView) view.findViewById(R.id.typeSpinner);
        this.downarrowIV = (ImageView) view.findViewById(R.id.downarrowIV);
        this.buttonProceed = (Button) view.findViewById(R.id.buttonProceed);
        RefreshDataList();
    }

    private void RefreshDataList() {
        Helper.showProgressDialog(this.activity);
        NetworkAPICall(API.API_CREATE_TEST_GET_QUES_COUNT, "", false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_test_three, container, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.API_CREATE_TEST_GET_QUES_COUNT)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setSubject_ids(this.subjectIds);
            encryptionData.setLang(this.LANG);
            return service.API_CREATE_TEST_GET_QUES_COUNT(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.API_CREATE_TEST_GET_TEST)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setSubject_ids(this.subjectIds);
        encryptionData2.setLimit(String.valueOf(this.enterQues));
        encryptionData2.setType(this.type);
        encryptionData2.setLang(this.LANG);
        encryptionData2.setQue_count(this.type_total_question);
        return service.API_CREATE_TEST_GET_TEST(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(final JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Helper.dismissProgressDialog();
        apitype.hashCode();
        if (!apitype.equals(API.API_CREATE_TEST_GET_QUES_COUNT)) {
            if (apitype.equals(API.API_CREATE_TEST_GET_TEST)) {
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentThree.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (jsonobject.optString("status").equals("true")) {
                                if (CreateTestFragmentThree.this.bottomSheetDialog != null && CreateTestFragmentThree.this.bottomSheetDialog.isShowing()) {
                                    CreateTestFragmentThree.this.bottomSheetDialog.dismiss();
                                }
                                CreateTestQuesData createTestQuesData = (CreateTestQuesData) new Gson().fromJson(jsonobject.toString(), CreateTestQuesData.class);
                                if (createTestQuesData != null && createTestQuesData.getData() != null) {
                                    Intent intent = new Intent(CreateTestFragmentThree.this.activity, (Class<?>) TestCreateActivity.class);
                                    Data data = new Data();
                                    TestBasic testBasic = new TestBasic();
                                    testBasic.setTestSeriesName("My Test");
                                    data.setTestBasic(testBasic);
                                    if (CreateTestFragmentThree.this.LANG.equalsIgnoreCase("3")) {
                                        if (createTestQuesData.getData().getQuestions_hindi() != null && createTestQuesData.getData().getData() != null) {
                                            if (createTestQuesData.getData().getData().size() >= createTestQuesData.getData().getQuestions_hindi().size()) {
                                                ArrayList<Question> data2 = createTestQuesData.getData().getData();
                                                ArrayList<Question> questions_hindi = createTestQuesData.getData().getQuestions_hindi();
                                                ArrayList arrayList = new ArrayList();
                                                ArrayList arrayList2 = new ArrayList();
                                                for (Question question : data2) {
                                                    Iterator<Question> it = questions_hindi.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            Question next = it.next();
                                                            if (question.getConfigId().equalsIgnoreCase(next.getConfigId())) {
                                                                question.setIsCorrect("0");
                                                                next.setIsCorrect("0");
                                                                arrayList.add(next);
                                                                arrayList2.add(question);
                                                                break;
                                                            }
                                                        } else {
                                                            question.setIsCorrect("0");
                                                            arrayList.add(question);
                                                            arrayList2.add(question);
                                                            break;
                                                        }
                                                    }
                                                }
                                                if (arrayList.size() > 0 && arrayList2.size() > 0) {
                                                    data.setQuestionsHindi(arrayList);
                                                    data.setQuestions(arrayList2);
                                                } else {
                                                    Toast.makeText(CreateTestFragmentThree.this.activity, CreateTestFragmentThree.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                                    return;
                                                }
                                            } else if (createTestQuesData.getData().getQuestions_hindi().size() >= createTestQuesData.getData().getData().size()) {
                                                ArrayList<Question> questions_hindi2 = createTestQuesData.getData().getQuestions_hindi();
                                                ArrayList arrayList3 = new ArrayList();
                                                ArrayList arrayList4 = new ArrayList();
                                                for (Question question2 : questions_hindi2) {
                                                    Iterator<Question> it2 = createTestQuesData.getData().getData().iterator();
                                                    while (true) {
                                                        if (it2.hasNext()) {
                                                            Question next2 = it2.next();
                                                            if (question2.getConfigId().equalsIgnoreCase(next2.getConfigId())) {
                                                                question2.setIsCorrect("0");
                                                                next2.setIsCorrect("0");
                                                                arrayList3.add(next2);
                                                                arrayList4.add(question2);
                                                                break;
                                                            }
                                                        } else {
                                                            question2.setIsCorrect("0");
                                                            arrayList3.add(question2);
                                                            arrayList4.add(question2);
                                                            break;
                                                        }
                                                    }
                                                }
                                                if (arrayList3.size() > 0 && arrayList4.size() > 0) {
                                                    data.setQuestions(arrayList3);
                                                    data.setQuestionsHindi(arrayList4);
                                                } else {
                                                    Toast.makeText(CreateTestFragmentThree.this.activity, CreateTestFragmentThree.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                                    return;
                                                }
                                            }
                                        }
                                    } else if (CreateTestFragmentThree.this.LANG.equalsIgnoreCase("2")) {
                                        if (createTestQuesData.getData().getQuestions_hindi() != null && createTestQuesData.getData().getQuestions_hindi().size() > 0) {
                                            data.setQuestions(createTestQuesData.getData().getQuestions_hindi());
                                        } else {
                                            Toast.makeText(CreateTestFragmentThree.this.activity, CreateTestFragmentThree.this.activity.getResources().getString(R.string.no_hindi_question_found), 0).show();
                                            return;
                                        }
                                    } else if (createTestQuesData.getData().getData() != null && createTestQuesData.getData().getData().size() > 0) {
                                        data.setQuestions(createTestQuesData.getData().getData());
                                    } else {
                                        Toast.makeText(CreateTestFragmentThree.this.activity, CreateTestFragmentThree.this.activity.getResources().getString(R.string.no_english_question_found), 0).show();
                                        return;
                                    }
                                    TestseriesBase testseriesBase = new TestseriesBase();
                                    testseriesBase.setData(data);
                                    if (data.getQuestions() != null && data.getQuestions().size() > 0) {
                                        ArrayList arrayList5 = new ArrayList();
                                        for (Question question3 : data.getQuestions()) {
                                            Questions2 questions2 = new Questions2();
                                            questions2.setId(question3.getId());
                                            questions2.setQuestionType(question3.getQuestionType());
                                            questions2.setQuestion(question3.getQuestion());
                                            questions2.setOption1(question3.getOption1());
                                            questions2.setOption2(question3.getOption2());
                                            questions2.setOption3(question3.getOption3());
                                            questions2.setOption4(question3.getOption4());
                                            questions2.setOption5(question3.getOption5());
                                            questions2.setAnswer(question3.getAnswer());
                                            questions2.setIsCorrect(0);
                                            arrayList5.add(questions2);
                                        }
                                        data.setQuestion_response(arrayList5);
                                        ArrayList arrayList6 = new ArrayList();
                                        for (Question question4 : data.getQuestions()) {
                                            Questions2 questions22 = new Questions2();
                                            questions22.setId(question4.getId());
                                            questions22.setQuestionType(question4.getQuestionType());
                                            questions22.setQuestion(question4.getQuestion());
                                            questions22.setOption1(question4.getOption1());
                                            questions22.setOption2(question4.getOption2());
                                            questions22.setOption3(question4.getOption3());
                                            questions22.setOption4(question4.getOption4());
                                            questions22.setOption5(question4.getOption5());
                                            questions22.setAnswer(question4.getAnswer());
                                            questions22.setIsCorrect(0);
                                            arrayList6.add(questions22);
                                        }
                                        data.setQuestion_response(arrayList6);
                                        intent.putExtra("status", false);
                                        intent.putExtra(Const.TEST_SERIES_ID, "");
                                        intent.putExtra(Const.TEST_SERIES_Name, "My Test");
                                        MakeMyExam.object = new Gson().toJson(testseriesBase);
                                        intent.putExtra(Const.TOTAL_QUESTIONS, data.getQuestions().size());
                                        intent.putExtra("first_attempt", "1");
                                        intent.putExtra(Const.VIA, "create");
                                        intent.putExtra(Const.LANG, Integer.parseInt(CreateTestFragmentThree.this.LANG));
                                        CreateTestFragmentThree.this.startActivity(intent);
                                        CreateTestFragmentThree.this.getActivity().finish();
                                        return;
                                    }
                                    Toast.makeText(CreateTestFragmentThree.this.activity, CreateTestFragmentThree.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                Toast.makeText(CreateTestFragmentThree.this.activity, CreateTestFragmentThree.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                return;
                            }
                            if (CreateTestFragmentThree.this.bottomSheetDialog != null && CreateTestFragmentThree.this.bottomSheetDialog.isShowing()) {
                                CreateTestFragmentThree.this.bottomSheetDialog.dismiss();
                            }
                            RetrofitResponse.GetApiData(CreateTestFragmentThree.this.getActivity(), jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                        } catch (Exception e2) {
                            if (CreateTestFragmentThree.this.bottomSheetDialog != null && CreateTestFragmentThree.this.bottomSheetDialog.isShowing()) {
                                CreateTestFragmentThree.this.bottomSheetDialog.dismiss();
                            }
                            e2.printStackTrace();
                        }
                    }
                }, 1000L);
                return;
            }
            return;
        }
        try {
            if (!jsonobject.optString("status").equals("true")) {
                RetrofitResponse.GetApiData(getActivity(), jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
            } else {
                this.questionCount = ((QuestionCountData) new Gson().fromJson(jsonobject.toString(), QuestionCountData.class)).getData();
                setData();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setData() {
        this.totalQues = Integer.parseInt(this.questionCount.getEasy()) + Integer.parseInt(this.questionCount.getHard()) + Integer.parseInt(this.questionCount.getMedium());
        this.totalquestion.setText(this.activity.getResources().getString(R.string.total_question) + String.valueOf(this.totalQues));
        this.lowTV.setText(this.questionCount.getEasy());
        this.mediumTV.setText(this.questionCount.getMedium());
        this.highTV.setText(this.questionCount.getHard());
        this.maxTV.setText(this.activity.getResources().getString(R.string.maximum_));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Helper.dismissProgressDialog();
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentThree.3
            @Override // java.lang.Runnable
            public void run() {
                if (CreateTestFragmentThree.this.bottomSheetDialog == null || !CreateTestFragmentThree.this.bottomSheetDialog.isShowing()) {
                    return;
                }
                CreateTestFragmentThree.this.bottomSheetDialog.dismiss();
            }
        }, 1000L);
    }

    public void createTestDialog() {
        try {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.activity, R.style.videosheetDialogTheme);
            this.bottomSheetDialog = bottomSheetDialog;
            bottomSheetDialog.setContentView(R.layout.create_test_loader);
            ((Window) Objects.requireNonNull(this.bottomSheetDialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            this.bottomSheetDialog.setCancelable(false);
            this.bottomSheetDialog.setCanceledOnTouchOutside(false);
            if (this.bottomSheetDialog.isShowing()) {
                return;
            }
            this.bottomSheetDialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        this.typeSpinner.setText(item.getTitle());
        if (this.questionCount == null) {
            return false;
        }
        if (item.getTitle().toString().equalsIgnoreCase("Low")) {
            this.type = "1";
            this.type_total_question = this.questionCount.getEasy();
            return false;
        }
        if (item.getTitle().toString().equalsIgnoreCase("Medium")) {
            this.type = "2";
            this.type_total_question = this.questionCount.getMedium();
            return false;
        }
        if (item.getTitle().toString().equalsIgnoreCase("High")) {
            this.type = "3";
            this.type_total_question = this.questionCount.getHard();
            return false;
        }
        this.type = "0";
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.downarrowIV || id == R.id.spinnerLL || id == R.id.typeSpinner) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new TypeTest("Low", "1"));
            arrayList.add(new TypeTest("Medium", "2"));
            arrayList.add(new TypeTest("High", "3"));
            PopupMenu popupMenu = new PopupMenu(this.activity, this.typeSpinner, 3);
            for (int i = 0; i < arrayList.size(); i++) {
                popupMenu.getMenu().add(((TypeTest) arrayList.get(i)).getName());
            }
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }
    }
}
