package com.appnew.android.CreateTest.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.CreateTest.Activity.CreateTestActivity;
import com.appnew.android.CreateTest.Model.CreateTestData;
import com.appnew.android.CreateTest.Model.CreateTestSubject;
import com.appnew.android.CreateTest.Model.TypeTest;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CreateTestFragmentTwo extends MainFragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    Activity activity;
    Button backBtn;
    RelativeLayout btnpcd;
    Button buttonProceed;
    RecyclerView createTestRV;
    String frag_type;
    LinearLayout llnote;
    RelativeLayout no_data_found_RL;
    RelativeLayout parentLL;
    RelativeLayout spinnerLL;
    TextView topText;
    String type;
    TextView typeSpinner;
    String courseIds = "";
    ArrayList<Courselist> courselists = new ArrayList<>();
    ArrayList<CreateTestSubject> createTestSubjects = new ArrayList<>();

    public static CreateTestFragmentTwo newInstance(String frag_type, ArrayList<Courselist> courselists, String lang) {
        CreateTestFragmentTwo createTestFragmentTwo = new CreateTestFragmentTwo();
        Bundle bundle = new Bundle();
        bundle.putString(Const.FRAG_TYPE, frag_type);
        bundle.putString(Const.LANG, lang);
        bundle.putSerializable(Const.CREATE_COURSE_DATA, courselists);
        createTestFragmentTwo.setArguments(bundle);
        return createTestFragmentTwo;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.type = getArguments().getString(Const.LANG);
            this.courselists = (ArrayList) getArguments().getSerializable(Const.CREATE_COURSE_DATA);
            ArrayList arrayList = new ArrayList();
            Iterator<Courselist> it = this.courselists.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getId());
            }
            this.courseIds = TextUtils.join(Constants.SEPARATOR_COMMA, arrayList);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        this.buttonProceed.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentTwo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ArrayList arrayList = new ArrayList();
                for (CreateTestSubject createTestSubject : CreateTestFragmentTwo.this.createTestSubjects) {
                    if (createTestSubject.isSelect()) {
                        arrayList.add(createTestSubject);
                    }
                }
                if (arrayList.size() > 0) {
                    Intent intent = new Intent(CreateTestFragmentTwo.this.activity, (Class<?>) CreateTestActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.CREATE_TEST_FRAG_THREE);
                    intent.putExtra(Const.CREATE_COURSE_SUBJECT_DATA, arrayList);
                    intent.putExtra(Const.LANG, CreateTestFragmentTwo.this.type);
                    CreateTestFragmentTwo.this.startActivity(intent);
                    return;
                }
                Toast.makeText(CreateTestFragmentTwo.this.activity, CreateTestFragmentTwo.this.activity.getResources().getString(R.string.please_select_atleast_one_subject), 0).show();
            }
        });
    }

    private void initView(View view) {
        this.parentLL = (RelativeLayout) view.findViewById(R.id.parentLL);
        this.typeSpinner = (TextView) view.findViewById(R.id.typeSpinner);
        this.topText = (TextView) view.findViewById(R.id.topText);
        this.createTestRV = (RecyclerView) view.findViewById(R.id.createTestRV);
        this.buttonProceed = (Button) view.findViewById(R.id.buttonProceed);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.backBtn = (Button) view.findViewById(R.id.backBtn);
        this.llnote = (LinearLayout) view.findViewById(R.id.llnote);
        this.btnpcd = (RelativeLayout) view.findViewById(R.id.btnpcd);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.spinnerLL);
        this.spinnerLL = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.typeSpinner.setOnClickListener(this);
        this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentTwo.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CreateTestFragmentTwo.this.activity.finish();
            }
        });
        RefreshDataList();
    }

    private void RefreshDataList() {
        Helper.showProgressDialog(this.activity);
        NetworkAPICall(API.API_CREATE_TEST_GET_SUBJECT, "", false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_test_two, container, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_CREATE_TEST_GET_SUBJECT)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_ids(this.courseIds);
        encryptionData.setType(this.type);
        return service.API_CREATE_TEST_GET_SUBJECT(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_CREATE_TEST_GET_SUBJECT)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonobject.optString("status").equals("true")) {
                    CreateTestData createTestData = (CreateTestData) new Gson().fromJson(jsonobject.toString(), CreateTestData.class);
                    if (createTestData.getData().size() > 0) {
                        ArrayList<CreateTestSubject> arrayList = new ArrayList<>();
                        this.createTestSubjects = arrayList;
                        arrayList.clear();
                        this.createTestRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                        this.btnpcd.setVisibility(0);
                        this.llnote.setVisibility(0);
                        this.createTestSubjects.addAll(createTestData.getData());
                        this.createTestRV.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
                        this.createTestRV.setAdapter(new SubjectListRecyclerAdapter(this.createTestSubjects, this.courselists));
                        this.createTestRV.setNestedScrollingEnabled(false);
                        return;
                    }
                    this.createTestRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    this.btnpcd.setVisibility(8);
                    this.llnote.setVisibility(8);
                    return;
                }
                this.createTestRV.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                this.btnpcd.setVisibility(8);
                this.llnote.setVisibility(8);
                RetrofitResponse.GetApiData(getActivity(), jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Helper.dismissProgressDialog();
        RecyclerView recyclerView = this.createTestRV;
        if (recyclerView == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
        this.btnpcd.setVisibility(8);
        this.llnote.setVisibility(8);
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        this.typeSpinner.setText(item.getTitle());
        if (item.getTitle().toString().equalsIgnoreCase("English")) {
            this.type = "1";
            return false;
        }
        if (item.getTitle().toString().equalsIgnoreCase("Hindi")) {
            this.type = "2";
            return false;
        }
        if (!item.getTitle().toString().equalsIgnoreCase("Both")) {
            return false;
        }
        this.type = "3";
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.spinnerLL || id == R.id.typeSpinner) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new TypeTest("English", "1"));
            arrayList.add(new TypeTest("Hindi", "2"));
            arrayList.add(new TypeTest("Both", "3"));
            PopupMenu popupMenu = new PopupMenu(this.activity, this.typeSpinner, 3);
            for (int i = 0; i < arrayList.size(); i++) {
                popupMenu.getMenu().add(((TypeTest) arrayList.get(i)).getName());
            }
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }
    }

    public class SubjectListRecyclerAdapter extends RecyclerView.Adapter<SubjectListHolder> {
        ArrayList<Courselist> courselists;
        ArrayList<CreateTestSubject> createTestSubjects;

        public SubjectListRecyclerAdapter(ArrayList<CreateTestSubject> createTestSubjects, ArrayList<Courselist> courselists) {
            this.courselists = courselists;
            this.createTestSubjects = createTestSubjects;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SubjectListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SubjectListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_subject_data, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.courselists.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SubjectListHolder holder, int position) {
            holder.setSingleFAQData(this.courselists.get(position), this.courselists.get(position).getTitle(), position);
        }

        public class SubjectListHolder extends RecyclerView.ViewHolder {
            private ImageView dropDownIV;
            private LinearLayout mainLL;
            private LinearLayout parentLL;
            private TextView questiontextTV;
            private RecyclerView subjectRV;

            public SubjectListHolder(View itemView) {
                super(itemView);
                this.questiontextTV = (TextView) itemView.findViewById(R.id.questiontextTV);
                this.dropDownIV = (ImageView) itemView.findViewById(R.id.dropDownIV);
                this.subjectRV = (RecyclerView) itemView.findViewById(R.id.subjectRV);
                this.mainLL = (LinearLayout) itemView.findViewById(R.id.lowerViewItem);
                this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            }

            public void setSingleFAQData(final Courselist courselists, String singlefaqdata, int pos) {
                if (courselists.isExpand()) {
                    this.mainLL.setVisibility(0);
                    this.dropDownIV.setImageResource(R.mipmap.up_black);
                } else {
                    this.mainLL.setVisibility(8);
                    this.dropDownIV.setImageResource(R.mipmap.down_black);
                }
                this.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentTwo.SubjectListRecyclerAdapter.SubjectListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (courselists.isExpand()) {
                            courselists.setExpand(false);
                            SubjectListHolder.this.mainLL.setVisibility(8);
                            SubjectListHolder.this.dropDownIV.setImageResource(R.mipmap.down_black);
                        } else {
                            courselists.setExpand(true);
                            SubjectListHolder.this.mainLL.setVisibility(0);
                            SubjectListHolder.this.dropDownIV.setImageResource(R.mipmap.up_black);
                        }
                    }
                });
                this.questiontextTV.setText(singlefaqdata);
                this.subjectRV.setLayoutManager(new LinearLayoutManager(CreateTestFragmentTwo.this.activity, 1, false));
                this.subjectRV.setAdapter(CreateTestFragmentTwo.this.new SubjectItemRecyclerAdapter(SubjectListRecyclerAdapter.this.createTestSubjects, SubjectListRecyclerAdapter.this.courselists.get(pos).getId()));
                this.subjectRV.setNestedScrollingEnabled(false);
            }
        }
    }

    public class SubjectItemRecyclerAdapter extends RecyclerView.Adapter<SubjectItemHolder> {
        ArrayList<CreateTestSubject> createTestSubjects;
        ArrayList<CreateTestSubject> createTestSubjectsFinal = new ArrayList<>();
        String selectedCourseID;

        public SubjectItemRecyclerAdapter(ArrayList<CreateTestSubject> createTestSubjects, String selectedCourseID) {
            this.createTestSubjects = createTestSubjects;
            this.selectedCourseID = selectedCourseID;
            for (CreateTestSubject createTestSubject : createTestSubjects) {
                if (selectedCourseID.equalsIgnoreCase(createTestSubject.getCourseId())) {
                    this.createTestSubjectsFinal.add(createTestSubject);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SubjectItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SubjectItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_subject_item, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.createTestSubjectsFinal.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SubjectItemHolder holder, int position) {
            holder.setSingleFAQData(this.createTestSubjectsFinal, position);
        }

        public class SubjectItemHolder extends RecyclerView.ViewHolder {
            private LinearLayout parentLL;
            private TextView questiontextTV;
            private CheckBox selectCB;

            public SubjectItemHolder(View itemView) {
                super(itemView);
                this.questiontextTV = (TextView) itemView.findViewById(R.id.questiontextTV);
                this.selectCB = (CheckBox) itemView.findViewById(R.id.selectCB);
                this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            }

            public void setSingleFAQData(ArrayList<CreateTestSubject> createTestSubjectsFinal, int pos) {
                final CreateTestSubject createTestSubject = createTestSubjectsFinal.get(pos);
                this.questiontextTV.setText((pos + 1) + ". " + (TextUtils.isEmpty(createTestSubject.getTitle()) ? "N/A" : createTestSubject.getTitle()));
                if (createTestSubject.isSelect()) {
                    this.selectCB.setChecked(true);
                } else {
                    this.selectCB.setChecked(false);
                }
                this.selectCB.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentTwo.SubjectItemRecyclerAdapter.SubjectItemHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (createTestSubject.isSelect()) {
                            createTestSubject.setSelect(false);
                        } else {
                            createTestSubject.setSelect(true);
                        }
                        SubjectItemRecyclerAdapter.this.checkProceedButton(CreateTestFragmentTwo.this.buttonProceed);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkProceedButton(Button buttonProceed) {
            boolean z;
            Iterator<CreateTestSubject> it = this.createTestSubjects.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().isSelect()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (CreateTestSubject createTestSubject : this.createTestSubjects) {
                if (createTestSubject.isSelect()) {
                    arrayList.add(createTestSubject);
                }
            }
            if (arrayList.size() > 0) {
                CreateTestFragmentTwo.this.topText.setText(arrayList.size() + CreateTestFragmentTwo.this.activity.getResources().getString(R.string.chapter_selected));
            } else {
                CreateTestFragmentTwo.this.topText.setText(CreateTestFragmentTwo.this.activity.getResources().getString(R.string.select_single_or_multiple_courses_s));
            }
            if (z) {
                buttonProceed.setBackground(CreateTestFragmentTwo.this.activity.getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
                buttonProceed.setTextColor(ContextCompat.getColor(CreateTestFragmentTwo.this.activity, R.color.whiteApp));
            } else {
                buttonProceed.setBackground(CreateTestFragmentTwo.this.activity.getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
                buttonProceed.setTextColor(ContextCompat.getColor(CreateTestFragmentTwo.this.activity, R.color.country_code_text_color));
            }
        }
    }
}
