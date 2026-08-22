package com.appnew.android.Webview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.FlashData;
import com.appnew.android.Model.Video;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Webview.Model.FlashDataDescription;
import com.appnew.android.Webview.Model.FlashDataTerm;
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
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class RevisionActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    TextView add_new_description;
    TextView add_new_terms_edittext;
    TextView add_revision_dialog;
    private TextView addonother;
    private String course_id;
    EditText description_edittext;
    private String f_id;
    CardView flashCards;
    private LinearLayout frame;
    View holderView;
    private ImageView image_back;
    long mLastClickTime_frame5;
    CardView mcqCards;
    int postion;
    private RelativeLayout question_layout;
    private TextView save_revision;
    EditText terms_edittext;
    private String tile_id;
    private String title;
    TextView toolbarTitleTV;
    private String via;
    private WebView webView;
    int count = 0;
    JSONArray array = new JSONArray();
    private JSONObject jsonObject = new JSONObject();
    private String video_id = "";
    private ArrayList<Video> seleced_tile_list = new ArrayList<>();
    private ArrayList<Video> videoArrayList = new ArrayList<>();
    private String url = "";

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.revisin_activity);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
            this.add_revision_dialog = (TextView) findViewById(R.id.add_revision_dialog);
            this.flashCards = (CardView) findViewById(R.id.flashCards);
            this.holderView = findViewById(R.id.holderView);
            this.mcqCards = (CardView) findViewById(R.id.mcqCards);
            this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
            this.frame = (LinearLayout) findViewById(R.id.frame);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            this.addonother = (TextView) findViewById(R.id.add_aonther);
            this.terms_edittext = (EditText) findViewById(R.id.terms_edittext);
            this.description_edittext = (EditText) findViewById(R.id.description_edittext);
            this.save_revision = (TextView) findViewById(R.id.save_revision);
            this.question_layout = (RelativeLayout) findViewById(R.id.question_layout);
            View viewFindViewById = findViewById(R.id.root);
            Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            if (Build.VERSION.SDK_INT == 36) {
                EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
            }
            final LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
            this.tile_id = getIntent().getStringExtra("t_id");
            this.postion = getIntent().getIntExtra("postion", 0);
            String stringExtra = getIntent().getStringExtra(Const.VIDEO_ID);
            this.video_id = stringExtra;
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.video_id = stringExtra;
            this.videoArrayList = (ArrayList) getIntent().getSerializableExtra("v_list");
            this.title = getIntent().getStringExtra("title");
            this.url = getIntent().getStringExtra("url");
            this.via = getIntent().getStringExtra(Const.VIA);
            String str = this.url;
            if (str != null && !str.equalsIgnoreCase("")) {
                String str2 = this.via;
                if (str2 != null && str2.equalsIgnoreCase("Notes")) {
                    this.flashCards.setVisibility(8);
                    this.holderView.setVisibility(8);
                    this.mcqCards.setVisibility(8);
                } else {
                    this.flashCards.setVisibility(0);
                    this.holderView.setVisibility(0);
                    this.mcqCards.setVisibility(0);
                }
                this.add_revision_dialog.setVisibility(8);
                this.question_layout.setVisibility(0);
                this.frame.setVisibility(0);
                this.addonother.setVisibility(0);
                this.save_revision.setVisibility(0);
                JSONArray jSONArray = new JSONArray(this.url);
                this.toolbarTitleTV.setText(this.title);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i == 0) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string = jSONObject.getString("terms");
                        String string2 = jSONObject.getString("description");
                        this.terms_edittext.setText(string);
                        this.description_edittext.setText(string2);
                        this.jsonObject.put("terms", this.terms_edittext.getText().toString());
                        this.jsonObject.put("description", this.description_edittext.getText().toString());
                        this.jsonObject.put("Q_id", jSONObject.getString("Q_id"));
                        this.array.put(this.jsonObject);
                    } else if (i > 0) {
                        this.count++;
                        View viewInflate = layoutInflater.inflate(R.layout.addonther_view, (ViewGroup) this.frame, false);
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String string3 = jSONObject2.getString("terms");
                        String string4 = jSONObject2.getString("description");
                        TextView textView = (TextView) viewInflate.findViewById(R.id.terms_edittext);
                        this.add_new_terms_edittext = textView;
                        textView.setTag(R.id.terms_edittext, Integer.valueOf(this.count));
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.description);
                        this.add_new_description = textView2;
                        textView2.setTag(R.id.description, Integer.valueOf(this.count));
                        this.add_new_terms_edittext.setText(string3);
                        this.add_new_description.setText(string4);
                        this.frame.setOrientation(1);
                        this.frame.addView(viewInflate);
                    }
                }
            }
            this.image_back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RevisionActivity.this.finish();
                }
            });
            this.course_id = getIntent().getStringExtra("c_id");
            this.f_id = getIntent().getStringExtra("f_id");
            this.add_revision_dialog.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$0(view);
                }
            });
            this.addonother.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$1(layoutInflater, view);
                }
            });
            this.flashCards.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(RevisionActivity.this, (Class<?>) FlashcardActivity.class);
                        intent.putExtra("url", RevisionActivity.this.url);
                        RevisionActivity.this.startActivity(intent);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            this.mcqCards.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        JSONArray jSONArray2 = new JSONArray(RevisionActivity.this.url);
                        ArrayList<FlashDataTerm> arrayList3 = new ArrayList();
                        ArrayList<FlashDataDescription> arrayList4 = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            FlashData flashData = (FlashData) new Gson().fromJson(jSONArray2.get(i2).toString(), FlashData.class);
                            arrayList3.add(new FlashDataTerm(flashData.getTerms(), flashData.getQ_id()));
                            arrayList4.add(new FlashDataDescription(flashData.getDescription(), flashData.getQ_id()));
                        }
                        for (FlashDataDescription flashDataDescription : arrayList4) {
                            ArrayList arrayList5 = new ArrayList();
                            String strJoin = "";
                            for (FlashDataTerm flashDataTerm : arrayList3) {
                                if (flashDataTerm.getQ_id().equalsIgnoreCase(flashDataDescription.getQ_id())) {
                                    arrayList5.add(0, flashDataTerm.getTerms());
                                } else {
                                    arrayList5.add(flashDataTerm.getTerms());
                                }
                                strJoin = TextUtils.join(Constants.SEPARATOR_COMMA, arrayList5);
                            }
                            Question question = new Question();
                            Questions2 questions2 = new Questions2();
                            String[] strArrSplit = strJoin.split(Constants.SEPARATOR_COMMA);
                            question.setRight_answer(strArrSplit[0].trim());
                            questions2.setRight_answer(strArrSplit[0].trim());
                            ArrayList arrayList6 = new ArrayList();
                            for (String str3 : strArrSplit) {
                                arrayList6.add(str3);
                                if (arrayList6.size() > 3) {
                                    break;
                                }
                            }
                            Collections.shuffle(arrayList6);
                            for (int i3 = 0; i3 < arrayList6.size(); i3++) {
                                if (question.getOption1() == null || question.getOption1().isEmpty()) {
                                    question.setOption1((String) arrayList6.get(i3));
                                    questions2.setOption1((String) arrayList6.get(i3));
                                } else if (question.getOption2() == null || question.getOption2().isEmpty()) {
                                    question.setOption2((String) arrayList6.get(i3));
                                    questions2.setOption2((String) arrayList6.get(i3));
                                } else if (question.getOption3() == null || question.getOption3().isEmpty()) {
                                    question.setOption3((String) arrayList6.get(i3));
                                    questions2.setOption3((String) arrayList6.get(i3));
                                } else if (question.getOption4() == null || question.getOption4().isEmpty()) {
                                    question.setOption4((String) arrayList6.get(i3));
                                    questions2.setOption3((String) arrayList6.get(i3));
                                    break;
                                }
                            }
                            question.setQuestion(flashDataDescription.getDescription());
                            question.setQuestionType("SC");
                            question.setId(flashDataDescription.getQ_id());
                            arrayList.add(question);
                            questions2.setQuestion(flashDataDescription.getDescription());
                            questions2.setQuestionType("SC");
                            questions2.setId(flashDataDescription.getQ_id());
                            arrayList2.add(questions2);
                        }
                        if (arrayList.size() > 0) {
                            Intent intent = new Intent(RevisionActivity.this, (Class<?>) RevisionTest.class);
                            Data data = new Data();
                            TestBasic testBasic = new TestBasic();
                            testBasic.setTestSeriesName(RevisionActivity.this.title);
                            data.setTestBasic(testBasic);
                            data.setQuestions(arrayList);
                            data.setQuestion_response(arrayList2);
                            TestseriesBase testseriesBase = new TestseriesBase();
                            testseriesBase.setData(data);
                            intent.putExtra("status", false);
                            intent.putExtra(Const.TEST_SERIES_ID, RevisionActivity.this.tile_id);
                            intent.putExtra(Const.TEST_SERIES_Name, RevisionActivity.this.title);
                            intent.putExtra("test_series", testseriesBase);
                            intent.putExtra(Const.TOTAL_QUESTIONS, arrayList.size());
                            intent.putExtra("first_attempt", "1");
                            intent.putExtra(Const.LANG, "1");
                            RevisionActivity.this.startActivity(intent);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            this.save_revision.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Webview.RevisionActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$2();
                }
            }));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        show_revision_bottomsheet_popup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(LayoutInflater layoutInflater, View view) {
        this.count++;
        View viewInflate = layoutInflater.inflate(R.layout.addonther_view, (ViewGroup) this.frame, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.terms_edittext);
        this.add_new_terms_edittext = textView;
        textView.setTag(R.id.terms_edittext, Integer.valueOf(this.count));
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.description);
        this.add_new_description = textView2;
        textView2.setTag(R.id.description, Integer.valueOf(this.count));
        this.frame.setOrientation(1);
        this.frame.addView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2() {
        try {
            if (this.array.length() == 0) {
                this.array = new JSONArray();
                if (this.terms_edittext.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(this, getResources().getString(R.string.enter_terms), 0).show();
                } else if (this.description_edittext.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(this, getResources().getString(R.string.enter_description), 0).show();
                } else if (this.count >= 1) {
                    this.jsonObject.put("terms", this.terms_edittext.getText().toString());
                    this.jsonObject.put("description", this.description_edittext.getText().toString());
                    this.jsonObject.put("Q_id", "" + gen());
                    this.array.put(this.jsonObject);
                    get_allrevision(this.frame);
                } else {
                    Toast.makeText(this, getResources().getString(R.string.at_least_two_revision_must_be_added), 0).show();
                }
            } else if (this.terms_edittext.getText().toString().equalsIgnoreCase("")) {
                Toast.makeText(this, getResources().getString(R.string.enter_terms), 0).show();
            } else if (this.description_edittext.getText().toString().equalsIgnoreCase("")) {
                Toast.makeText(this, getResources().getString(R.string.enter_description), 0).show();
            } else if (this.via.equalsIgnoreCase("main")) {
                this.array.remove(0);
                this.jsonObject.put("terms", this.terms_edittext.getText().toString());
                this.jsonObject.put("description", this.description_edittext.getText().toString());
                this.jsonObject.put("Q_id", "" + gen());
                this.array.put(this.jsonObject);
                get_allrevision(this.frame);
            } else {
                show_revision_bottomsheet_popup();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void show_revision_bottomsheet_popup() {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime_frame5 < 1000) {
                return;
            }
            this.mLastClickTime_frame5 = SystemClock.elapsedRealtime();
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.videosheetDialogTheme);
            bottomSheetDialog.setContentView(R.layout.revision_dialog);
            bottomSheetDialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            bottomSheetDialog.setCancelable(false);
            bottomSheetDialog.setCanceledOnTouchOutside(false);
            RelativeLayout relativeLayout = (RelativeLayout) bottomSheetDialog.findViewById(R.id.calcpagerl);
            TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.btn__cancel);
            final EditText editText = (EditText) bottomSheetDialog.findViewById(R.id.writeCouponET);
            ((TextView) bottomSheetDialog.findViewById(R.id.btn_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$show_revision_bottomsheet_popup$3(editText, bottomSheetDialog, view);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RevisionActivity.this.dismissCalculatorDialog(bottomSheetDialog);
                }
            });
            ((RelativeLayout) Objects.requireNonNull(relativeLayout)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RevisionActivity.this.dismissCalculatorDialog(bottomSheetDialog);
                }
            });
            bottomSheetDialog.show();
            bottomSheetDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.Webview.RevisionActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    bottomSheetDialog.dismiss();
                    bottomSheetDialog.cancel();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show_revision_bottomsheet_popup$3(EditText editText, BottomSheetDialog bottomSheetDialog, View view) {
        if (!editText.getText().toString().trim().equalsIgnoreCase("")) {
            this.toolbarTitleTV.setText(editText.getText().toString().trim());
            if (this.via.equalsIgnoreCase("notes")) {
                try {
                    dismissCalculatorDialog(bottomSheetDialog);
                    this.array.remove(0);
                    this.jsonObject.put("terms", this.terms_edittext.getText().toString());
                    this.jsonObject.put("description", this.description_edittext.getText().toString());
                    this.jsonObject.put("Q_id", "" + gen());
                    this.array.put(this.jsonObject);
                    get_allrevision(this.frame);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            this.add_revision_dialog.setVisibility(8);
            this.addonother.setVisibility(0);
            this.save_revision.setVisibility(0);
            this.frame.setVisibility(0);
            this.question_layout.setVisibility(0);
            dismissCalculatorDialog(bottomSheetDialog);
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.enter_revision_title), 0).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[Catch: Exception -> 0x00c7, TryCatch #0 {Exception -> 0x00c7, blocks: (B:3:0x0003, B:6:0x000c, B:8:0x0019, B:10:0x002c, B:12:0x0047, B:14:0x005b, B:15:0x0069, B:17:0x006d, B:19:0x0087, B:20:0x009a, B:21:0x00b6, B:23:0x00bc), top: B:28:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void get_allrevision(android.widget.LinearLayout r11) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Webview.RevisionActivity.get_allrevision(android.widget.LinearLayout):void");
    }

    private void show_revison_dialog() {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime_frame5 < 1000) {
                return;
            }
            this.mLastClickTime_frame5 = SystemClock.elapsedRealtime();
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.revision_dialog);
            dialog.getWindow().setSoftInputMode(16);
            getWindow().setSoftInputMode(3);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
            dialog.getWindow().setGravity(17);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.calcpagerl);
            TextView textView = (TextView) dialog.findViewById(R.id.btn__cancel);
            final EditText editText = (EditText) dialog.findViewById(R.id.writeCouponET);
            ((TextView) dialog.findViewById(R.id.btn_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$show_revison_dialog$4(editText, dialog, view);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RevisionActivity.this.dismissCalculatorDialog(dialog);
                }
            });
            ((RelativeLayout) Objects.requireNonNull(relativeLayout)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RevisionActivity.this.dismissCalculatorDialog(dialog);
                }
            });
            dialog.show();
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.Webview.RevisionActivity.9
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialog.dismiss();
                    dialog.cancel();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show_revison_dialog$4(EditText editText, Dialog dialog, View view) {
        if (!editText.getText().toString().trim().equalsIgnoreCase("")) {
            this.toolbarTitleTV.setText(editText.getText().toString().trim());
            if (this.via.equalsIgnoreCase("notes")) {
                try {
                    dismissCalculatorDialog(dialog);
                    this.array.remove(0);
                    this.jsonObject.put("terms", this.terms_edittext.getText().toString());
                    this.jsonObject.put("description", this.description_edittext.getText().toString());
                    this.jsonObject.put("Q_id", "" + gen());
                    this.array.put(this.jsonObject);
                    get_allrevision(this.frame);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            this.add_revision_dialog.setVisibility(8);
            this.addonother.setVisibility(0);
            this.save_revision.setVisibility(0);
            this.frame.setVisibility(0);
            this.question_layout.setVisibility(0);
            dismissCalculatorDialog(dialog);
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.enter_revision_title), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissCalculatorDialog(Dialog watchlist) {
        if (watchlist == null || !watchlist.isShowing()) {
            return;
        }
        watchlist.dismiss();
        watchlist.cancel();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.video_link)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setId(this.video_id);
        encryptionData.setCourse_id(this.course_id);
        encryptionData.setType("3");
        encryptionData.setFile_id(this.f_id);
        encryptionData.setTile_id(this.tile_id);
        encryptionData.setLink(this.array.toString());
        encryptionData.setTitle(this.toolbarTitleTV.getText().toString().trim());
        return service.video_link(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.video_link)) {
            try {
                if (!jsonstring.optString("status").equals("true")) {
                    RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    return;
                }
                com.appnew.android.home.Constants.revison_set = true;
                Video video = (Video) new Gson().fromJson(jsonstring.optJSONObject("data").toString(), Video.class);
                if (this.via.equalsIgnoreCase("main")) {
                    if (this.video_id.equalsIgnoreCase("")) {
                        ArrayList<Video> arrayList = this.videoArrayList;
                        arrayList.add(arrayList.size(), video);
                    } else {
                        this.videoArrayList.set(this.postion, video);
                    }
                    MakeMyExam.videoArrayList = this.videoArrayList;
                    Toast.makeText(this, "" + jsonstring.optString("message"), 0).show();
                    finish();
                    return;
                }
                if (this.video_id.equalsIgnoreCase("")) {
                    this.video_id = video.getId();
                    ArrayList<Video> arrayList2 = this.videoArrayList;
                    arrayList2.add(arrayList2.size(), video);
                } else {
                    ArrayList<Video> arrayList3 = this.videoArrayList;
                    arrayList3.set(arrayList3.size() - 1, video);
                }
                MakeMyExam.videoArrayList = this.videoArrayList;
                this.url = video.getFile_url();
                Toast.makeText(this, "" + jsonstring.optString("message"), 0).show();
                this.flashCards.setVisibility(0);
                this.holderView.setVisibility(0);
                this.mcqCards.setVisibility(0);
            } catch (Exception e2) {
                ErrorCallBack(e2.getMessage() + " : " + e2.getLocalizedMessage(), apitype, typeApi);
                e2.printStackTrace();
            }
        }
    }

    public int gen() {
        return new Random().nextInt(900000) + 100000;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * ((double) (max - min))) + ((double) min));
    }
}
