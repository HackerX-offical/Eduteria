package com.appnew.android.Courses.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Adapter.MyNotesRecyclerAdapter;
import com.appnew.android.Courses.Interfaces.OnMyNotesItemListener;
import com.appnew.android.Courses.Modal.NotesPDF.NoteData;
import com.appnew.android.Courses.Modal.NotesPDF.NoteList;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import com.github.clans.fab.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class MyNotesActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, OnMyNotesItemListener {
    Context context;
    String courseId;
    Dialog dialog;
    FloatingActionButton floatingActionButton;
    ImageView imageIV;
    ImageView iv_back;
    LinearLayoutManager linearLayoutManager;
    NestedScrollView ll_main;
    MyNotesRecyclerAdapter myNotesRecyclerAdapter;
    NetworkCall networkCall;
    ArrayList<NoteData> noteList = new ArrayList<>();
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

    @Override // com.appnew.android.Courses.Interfaces.OnMyNotesItemListener
    public void onMyNotesItemClick(NoteData myNotes) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        this.context = this;
        Helper.enableScreenShot(this);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        setContentView(R.layout.activity_my_notes);
        setSupportActionBar((Toolbar) findViewById(R.id.myProgress_toolbar));
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        this.iv_back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.MyNotesActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MyNotesActivity.this.onBackPressed();
            }
        });
        this.networkCall = new NetworkCall(this, this);
        this.video = (Video) getIntent().getExtras().getSerializable("video");
        this.courseId = getIntent().getExtras().getString("course_id");
        this.tileId = getIntent().getExtras().getString("tile_id");
        if (getIntent().getExtras().getString("notes_data") != null && !getIntent().getExtras().getString("notes_data").equalsIgnoreCase("")) {
            this.noteList = (ArrayList) new Gson().fromJson(getIntent().getExtras().getString("notes_data"), new TypeToken<ArrayList<NoteData>>() { // from class: com.appnew.android.Courses.Activity.MyNotesActivity.2
            }.getType());
        }
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_notes);
        this.recycler_notes = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.tv_no_data_found = (TextView) findViewById(R.id.tv_no_data_found);
        this.ll_main = (NestedScrollView) findViewById(R.id.ll_main);
        this.imageIV = (ImageView) findViewById(R.id.imageIV);
        this.floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_button);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context, 1, false);
        this.linearLayoutManager = linearLayoutManager;
        this.recycler_notes.setLayoutManager(linearLayoutManager);
        createRecycler(this.noteList);
        this.floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.MyNotesActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(MyNotesActivity.this, (Class<?>) MyNotesSelectionActivity.class);
                intent.putExtra("video", MyNotesActivity.this.video);
                intent.putExtra(Const.NOTE_DATA, MyNotesActivity.this.noteList);
                intent.putExtra("course_id", MyNotesActivity.this.courseId);
                intent.putExtra("tile_id", MyNotesActivity.this.tileId);
                Helper.gotoActivity_finish(intent, MyNotesActivity.this);
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
                MyNotesRecyclerAdapter myNotesRecyclerAdapter = new MyNotesRecyclerAdapter(this.context, myNotesArrayList);
                this.myNotesRecyclerAdapter = myNotesRecyclerAdapter;
                this.recycler_notes.setAdapter(myNotesRecyclerAdapter);
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

    @Override // com.appnew.android.Courses.Interfaces.OnMyNotesItemListener
    public void onMyNotesEditClick(NoteData myNotes, int position) {
        if (myNotes.getType().equalsIgnoreCase(Const.NOTE)) {
            showDialogAddNote(myNotes, position);
        } else {
            editDeleteNoteList("delete", myNotes, position);
        }
    }

    @Override // com.appnew.android.Courses.Interfaces.OnMyNotesItemListener
    public void onMyNotesDeleteClick(NoteData myNotes, int position) {
        editDeleteNoteList("delete", myNotes, position);
    }

    public void showDialogAddNote(final NoteData noteData, final int position) {
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            this.dialog.dismiss();
        }
        Dialog dialog2 = new Dialog(this.context);
        this.dialog = dialog2;
        dialog2.setCancelable(false);
        this.dialog.requestWindowFeature(1);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        this.dialog.setContentView(R.layout.add_notes_dialog);
        TextView textView = (TextView) this.dialog.findViewById(R.id.TV1);
        final EditText editText = (EditText) this.dialog.findViewById(R.id.noteTV);
        Button button = (Button) this.dialog.findViewById(R.id.cancelBtn);
        Button button2 = (Button) this.dialog.findViewById(R.id.submitBtn);
        textView.setText(getResources().getString(R.string.add_note_message));
        if (noteData != null && !TextUtils.isEmpty(noteData.getTitle())) {
            editText.setText(noteData.getTitle());
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.MyNotesActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.hideSoftKeyboard(MyNotesActivity.this);
                try {
                    MyNotesActivity.this.dismissProgressDialog();
                } catch (Exception unused) {
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.MyNotesActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.hideSoftKeyboard(MyNotesActivity.this);
                String strTrim = editText.getText().toString().trim();
                NoteData noteData2 = noteData;
                if (TextUtils.isEmpty(strTrim)) {
                    strTrim = "";
                }
                noteData2.setTitle(strTrim);
                MyNotesActivity.this.editDeleteNoteList("edit", noteData, position);
                try {
                    MyNotesActivity.this.dismissProgressDialog();
                } catch (Exception unused) {
                }
            }
        });
        if (((Activity) this.context).isFinishing()) {
            return;
        }
        this.dialog.show();
    }

    public void dismissProgressDialog() {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    public void editDeleteNoteList(String noteType, NoteData noteData, int position) {
        try {
            if (noteType.equalsIgnoreCase("edit")) {
                this.noteList.set(position, noteData);
                SharedPreference.getInstance().setNoteData(new NoteList(this.noteList));
                MyNotesRecyclerAdapter myNotesRecyclerAdapter = this.myNotesRecyclerAdapter;
                if (myNotesRecyclerAdapter != null) {
                    myNotesRecyclerAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.noteList.remove(position);
            SharedPreference.getInstance().setNoteData(new NoteList(this.noteList));
            MyNotesRecyclerAdapter myNotesRecyclerAdapter2 = this.myNotesRecyclerAdapter;
            if (myNotesRecyclerAdapter2 != null) {
                myNotesRecyclerAdapter2.notifyItemRemoved(position);
                this.myNotesRecyclerAdapter.notifyItemRangeChanged(position, this.noteList.size());
            }
            if (SharedPreference.getInstance().getNoteData() == null || SharedPreference.getInstance().getNoteData().getNoteList() == null || SharedPreference.getInstance().getNoteData().getNoteList().size() <= 0) {
                this.ll_main.setVisibility(8);
                this.tv_no_data_found.setText(getResources().getString(R.string.no_data_found));
                this.tv_no_data_found.setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        dismissProgressDialog();
        super.onDestroy();
    }
}
