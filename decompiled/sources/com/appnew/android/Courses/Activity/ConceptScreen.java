package com.appnew.android.Courses.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Courses.Modal.NotesPDF.NoteData;
import com.appnew.android.Courses.Modal.NotesPDF.NoteList;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.ImageGetter;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ConceptScreen extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    private static final String TAG = "ConceptScreen";
    ImageView back;
    ClipboardManager clipboard;
    TextView concept_name;
    Activity context;
    String courseId;
    Dialog dialog;
    NetworkCall networkCall;
    String noteString;
    String noteTitle;
    ImageView notesIV;
    private TextView textView;
    String tileId;
    Video video;
    Spannable WordtoSpan = null;
    ArrayList<NoteData> noteList = new ArrayList<>();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.concept_screen);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        this.context = this;
        this.courseId = getIntent().getExtras().getString("course_id");
        this.networkCall = new NetworkCall(this, this);
        this.video = (Video) getIntent().getExtras().getSerializable("video");
        this.courseId = getIntent().getExtras().getString("course_id");
        this.tileId = getIntent().getExtras().getString("tile_id");
        if (MakeMyExam.userId.equalsIgnoreCase("") || MakeMyExam.userId.equalsIgnoreCase("0")) {
            MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
            MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
        }
        intitalizeView();
    }

    private void intitalizeView() {
        this.textView = (TextView) findViewById(R.id.txt);
        this.concept_name = (TextView) findViewById(R.id.concept_name);
        this.notesIV = (ImageView) findViewById(R.id.notesIV);
        this.back = (ImageView) findViewById(R.id.back);
        this.textView.setBackgroundColor(getResources().getColor(R.color.white));
        this.textView.setText(Html.fromHtml(this.video.getDescription().trim(), 0));
        this.textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.textView.setLinkTextColor(getResources().getColor(R.color.blue));
        this.textView.setTextIsSelectable(true);
        this.textView.setFocusable(true);
        this.textView.setFocusableInTouchMode(true);
        this.concept_name.setText(this.video.getTitle());
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.ConceptScreen.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ConceptScreen.this.finish();
            }
        });
        this.notesIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.ConceptScreen.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SharedPreference.getInstance().getNoteData() != null && SharedPreference.getInstance().getNoteData().getNoteList() != null && SharedPreference.getInstance().getNoteData().getNoteList().size() > 0) {
                    Intent intent = new Intent(ConceptScreen.this, (Class<?>) MyNotesActivity.class);
                    intent.putExtra("video", ConceptScreen.this.video);
                    intent.putExtra("course_id", ConceptScreen.this.courseId);
                    intent.putExtra("tile_id", ConceptScreen.this.tileId);
                    ConceptScreen.this.startActivity(intent);
                    return;
                }
                ConceptScreen conceptScreen = ConceptScreen.this;
                Toast.makeText(conceptScreen, conceptScreen.getResources().getString(R.string.no_notes_found), 0).show();
            }
        });
    }

    private void setData() {
        String string = Html.fromHtml(this.video.getDescription(), new ImageGetter(this), null).toString();
        this.noteList = new ArrayList<>();
        if (SharedPreference.getInstance().getNoteData() != null && SharedPreference.getInstance().getNoteData().getNoteList() != null && SharedPreference.getInstance().getNoteData().getNoteList().size() > 0) {
            for (NoteData noteData : SharedPreference.getInstance().getNoteData().getNoteList()) {
                if (noteData.getUserId().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getId()) && noteData.getConceptId().equalsIgnoreCase(this.video.getId())) {
                    this.noteList.add(noteData);
                }
            }
        }
        try {
            ArrayList<NoteData> arrayList = this.noteList;
            if (arrayList != null && arrayList.size() > 0) {
                this.WordtoSpan = new SpannableString(string);
                for (NoteData noteData2 : this.noteList) {
                    int start = noteData2.getStart();
                    int end = noteData2.getEnd();
                    if (noteData2.getType().equalsIgnoreCase(Const.NOTE)) {
                        this.WordtoSpan.setSpan(new BackgroundColorSpan(-256), start, end, 33);
                    } else {
                        this.WordtoSpan.setSpan(new BackgroundColorSpan(-9645313), start, end, 33);
                    }
                }
                this.textView.setText(this.WordtoSpan);
            } else {
                SpannableString spannableString = new SpannableString(string);
                this.WordtoSpan = spannableString;
                this.textView.setText(spannableString);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            final CharSequence[] charSequenceArr = {""};
            this.textView.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: com.appnew.android.Courses.Activity.ConceptScreen.3
                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    menu.removeItem(android.R.id.selectAll);
                    menu.removeItem(android.R.id.cut);
                    menu.removeItem(android.R.id.copy);
                    menu.removeItem(android.R.id.shareText);
                    return true;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    menu.add(0, 1, 0, ConceptScreen.this.getResources().getString(R.string.highlight));
                    menu.add(0, 2, 0, ConceptScreen.this.getResources().getString(R.string.notes));
                    menu.add(0, 3, 0, ConceptScreen.this.getResources().getString(R.string.search__));
                    return true;
                }

                /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0141  */
                @Override // android.view.ActionMode.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public boolean onActionItemClicked(android.view.ActionMode r9, android.view.MenuItem r10) {
                    /*
                        Method dump skipped, instruction units count: 398
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Activity.ConceptScreen.AnonymousClass3.onActionItemClicked(android.view.ActionMode, android.view.MenuItem):boolean");
                }
            });
        } catch (Exception unused) {
        }
    }

    public void showDialogAddNote(final String note, final int start, final int end) {
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.ConceptScreen.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.hideSoftKeyboard(ConceptScreen.this.context);
                try {
                    ConceptScreen.this.dismissProgressDialog();
                } catch (Exception unused) {
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.ConceptScreen.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.hideSoftKeyboard(ConceptScreen.this.context);
                ConceptScreen.this.WordtoSpan.setSpan(new BackgroundColorSpan(-256), start, end, 33);
                ConceptScreen.this.textView.setText(ConceptScreen.this.WordtoSpan);
                ConceptScreen.this.noteString = note;
                ConceptScreen.this.noteTitle = editText.getText().toString().trim();
                ConceptScreen conceptScreen = ConceptScreen.this;
                conceptScreen.setNoteList(conceptScreen.noteString, TextUtils.isEmpty(ConceptScreen.this.noteTitle) ? "" : ConceptScreen.this.noteTitle, Const.NOTE, start, end);
                try {
                    ConceptScreen.this.dismissProgressDialog();
                } catch (Exception unused) {
                }
            }
        });
        if (this.context.isFinishing()) {
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        dismissProgressDialog();
        super.onDestroy();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_ADD_MY_NOTES)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        encryptionData.setNote_data(this.noteString);
        encryptionData.setConcept_id(this.video.getId());
        return service.addMyNotesData(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_ADD_MY_NOTES)) {
            if (jsonobject.optString("status").equals("true")) {
                Toast.makeText(this.context, jsonobject.optString("message"), 0).show();
            } else {
                Toast.makeText(this.context, jsonobject.optString("message"), 0).show();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this.context, jsonstring, 0).show();
    }

    public void setNoteList(String queryData, String title, String type, int start, int end) {
        try {
            if (TextUtils.isEmpty(queryData)) {
                return;
            }
            NoteData noteData = new NoteData(MakeMyExam.userId, this.video.getId(), queryData, title, type, start, end);
            if (SharedPreference.getInstance().getNoteData() != null) {
                ArrayList<NoteData> noteList = SharedPreference.getInstance().getNoteData().getNoteList();
                if (noteList != null && noteList.size() > 0) {
                    boolean z = false;
                    for (int i = 0; i < noteList.size(); i++) {
                        if (noteList.get(i).getUserId().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getId()) && noteList.get(i).getConceptId().equalsIgnoreCase(this.video.getId()) && noteList.get(i).getQueryData().equalsIgnoreCase(queryData) && noteList.get(i).getStart() == start && noteList.get(i).getEnd() == end) {
                            noteList.set(i, noteData);
                            z = true;
                        }
                    }
                    if (!z) {
                        noteList.add(noteData);
                        SharedPreference.getInstance().setNoteData(new NoteList(noteList));
                        return;
                    } else {
                        SharedPreference.getInstance().setNoteData(new NoteList(noteList));
                        return;
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(noteData);
                SharedPreference.getInstance().setNoteData(new NoteList(arrayList));
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(noteData);
            SharedPreference.getInstance().setNoteData(new NoteList(arrayList2));
        } catch (Exception unused) {
        }
    }
}
