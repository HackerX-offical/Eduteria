package com.appnew.android.Courses.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Fragment.ExamPrepLayer2;
import com.appnew.android.Courses.Modal.NotesPDF.NoteData;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Webview.RevisionActivity;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class MyNotesSelectionActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    ImageView back;
    Button buttonProceed;
    Context context;
    String courseId;
    ImageView imageIV;
    LinearLayoutManager linearLayoutManager;
    NestedScrollView ll_main;
    ArrayList<NoteData> myNotesArrayList = new ArrayList<>();
    NoteItemRecyclerAdapter myNotesRecyclerAdapter;
    NetworkCall networkCall;
    RecyclerView recycler_notes;
    String tileId;
    TextView tv_no_data_found;
    Video video;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        this.context = this;
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_my_notes_selection);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        setSupportActionBar((Toolbar) findViewById(R.id.myProgress_toolbar));
        ImageView imageView = (ImageView) findViewById(R.id.back);
        this.back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.MyNotesSelectionActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.networkCall = new NetworkCall(this, this);
        this.video = (Video) getIntent().getExtras().getSerializable("video");
        this.myNotesArrayList = (ArrayList) getIntent().getExtras().getSerializable(Const.NOTE_DATA);
        this.courseId = getIntent().getExtras().getString("course_id");
        this.tileId = getIntent().getExtras().getString("tile_id");
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        onBackPressed();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_notes);
        this.recycler_notes = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.tv_no_data_found = (TextView) findViewById(R.id.tv_no_data_found);
        this.ll_main = (NestedScrollView) findViewById(R.id.ll_main);
        this.imageIV = (ImageView) findViewById(R.id.imageIV);
        this.buttonProceed = (Button) findViewById(R.id.buttonProceed);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context, 1, false);
        this.linearLayoutManager = linearLayoutManager;
        this.recycler_notes.setLayoutManager(linearLayoutManager);
        createRecycler(this.myNotesArrayList);
        this.buttonProceed.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.MyNotesSelectionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayList = new ArrayList();
                for (NoteData noteData : MyNotesSelectionActivity.this.myNotesArrayList) {
                    if (noteData.isSelect()) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("terms", "");
                            jSONObject.put("description", noteData.getQueryData());
                            jSONObject.put("Q_id", MyNotesSelectionActivity.this.gen());
                            jSONArray.put(jSONObject);
                            arrayList.add(noteData);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (arrayList.size() >= 2) {
                    Intent intent = new Intent(MyNotesSelectionActivity.this, (Class<?>) RevisionActivity.class);
                    intent.putExtra("t_id", MyNotesSelectionActivity.this.tileId);
                    intent.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                    intent.putExtra("f_id", MyNotesSelectionActivity.this.video.getId());
                    intent.putExtra("c_id", MyNotesSelectionActivity.this.courseId);
                    intent.putExtra("title", MyNotesSelectionActivity.this.video.getTitle());
                    intent.putExtra("url", jSONArray.toString());
                    intent.putExtra(Const.VIA, "notes");
                    Helper.gotoActivity_finish(intent, MyNotesSelectionActivity.this);
                    return;
                }
                Snackbar.make(v, MyNotesSelectionActivity.this.getResources().getString(R.string.please_select_atleast_two_notes), -1).show();
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        checkOnBackPressAction();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        checkOnBackPressAction();
        return true;
    }

    public void checkOnBackPressAction() {
        supportFinishAfterTransition();
    }

    private void createRecycler(ArrayList<NoteData> myNotesArrayList) {
        if (myNotesArrayList != null) {
            if (myNotesArrayList.size() > 0) {
                this.ll_main.setVisibility(0);
                this.tv_no_data_found.setVisibility(8);
                NoteItemRecyclerAdapter noteItemRecyclerAdapter = new NoteItemRecyclerAdapter(myNotesArrayList);
                this.myNotesRecyclerAdapter = noteItemRecyclerAdapter;
                this.recycler_notes.setAdapter(noteItemRecyclerAdapter);
                return;
            }
            this.ll_main.setVisibility(8);
            this.tv_no_data_found.setText(getResources().getString(R.string.no_data_found));
            this.tv_no_data_found.setVisibility(0);
            return;
        }
        this.ll_main.setVisibility(8);
        this.tv_no_data_found.setText(getResources().getString(R.string.no_data_found));
        this.tv_no_data_found.setVisibility(0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public class NoteItemRecyclerAdapter extends RecyclerView.Adapter<SubjectItemHolder> {
        ArrayList<NoteData> myNotesArrayList;

        public NoteItemRecyclerAdapter(ArrayList<NoteData> myNotesArrayList) {
            this.myNotesArrayList = myNotesArrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SubjectItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SubjectItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_note_item, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.myNotesArrayList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SubjectItemHolder holder, int position) {
            holder.setSingleFAQData(this.myNotesArrayList, position);
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

            public void setSingleFAQData(ArrayList<NoteData> createTestSubjectsFinal, int pos) {
                final NoteData noteData = createTestSubjectsFinal.get(pos);
                this.questiontextTV.setText((pos + 1) + ". " + (TextUtils.isEmpty(noteData.getQueryData()) ? MyNotesSelectionActivity.this.getResources().getString(R.string.n_a) : noteData.getQueryData()));
                if (noteData.isSelect()) {
                    this.selectCB.setChecked(true);
                } else {
                    this.selectCB.setChecked(false);
                }
                this.selectCB.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.MyNotesSelectionActivity.NoteItemRecyclerAdapter.SubjectItemHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (noteData.isSelect()) {
                            noteData.setSelect(false);
                        } else {
                            noteData.setSelect(true);
                        }
                        NoteItemRecyclerAdapter.this.checkProceedButton(MyNotesSelectionActivity.this.buttonProceed);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkProceedButton(Button buttonProceed) {
            boolean z;
            Iterator<NoteData> it = this.myNotesArrayList.iterator();
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
            for (NoteData noteData : this.myNotesArrayList) {
                if (noteData.isSelect()) {
                    arrayList.add(noteData);
                }
            }
            if (z) {
                buttonProceed.setBackground(MyNotesSelectionActivity.this.getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
                buttonProceed.setTextColor(ContextCompat.getColor(MyNotesSelectionActivity.this, R.color.whiteApp));
            } else {
                buttonProceed.setBackground(MyNotesSelectionActivity.this.getResources().getDrawable(R.drawable.bg_round_corners_button_fade));
                buttonProceed.setTextColor(ContextCompat.getColor(MyNotesSelectionActivity.this, R.color.country_code_text_color));
            }
        }
    }

    public int gen() {
        return new Random().nextInt(900000) + 100000;
    }
}
