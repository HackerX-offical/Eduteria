package com.appnew.android.CourseTransfer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.model.MyCourse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CourseTransferActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    private Button backBtn;
    Button buttonProceed;
    CourseSelectionAdapter courseSelectionAdapter;
    RecyclerView course_name_recycler;
    Dialog dialog;
    private ImageView image_back;
    LinearLayoutManager linearLayoutManager;
    private long mLastClickTime_frame5;
    EditText m_no;
    private MyCourse myCourse;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    RelativeLayout proceed_layout;
    private ImageView refresh;
    ArrayList<Courselist> course_list = new ArrayList<>();
    private ArrayList<Courselist> noteDataArrayList = new ArrayList<>();

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_course_treansfer);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            this.course_name_recycler = (RecyclerView) findViewById(R.id.course_name_recycler);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            this.refresh = (ImageView) findViewById(R.id.refresh);
            this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) findViewById(R.id.backBtn);
            this.buttonProceed = (Button) findViewById(R.id.buttonProceed);
            this.proceed_layout = (RelativeLayout) findViewById(R.id.proceed);
            this.m_no = (EditText) findViewById(R.id.m_no);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
            this.linearLayoutManager = linearLayoutManager;
            this.course_name_recycler.setLayoutManager(linearLayoutManager);
            NetworkCall networkCall = new NetworkCall(this, this);
            this.networkCall = networkCall;
            networkCall.NetworkAPICall(API.get_my_courses, "", true, false);
            this.buttonProceed.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$0(view);
                }
            });
            this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$1();
                }
            }));
            this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$2();
                }
            }));
            this.refresh.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$3(view);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (this.buttonProceed.getText().toString().equalsIgnoreCase("Course Transfer")) {
            this.noteDataArrayList = new ArrayList<>();
            for (Courselist courselist : this.course_list) {
                if (courselist.isSelect()) {
                    try {
                        this.noteDataArrayList.add(courselist);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            ArrayList<Courselist> arrayList = this.noteDataArrayList;
            if (arrayList != null && arrayList.size() > 0) {
                alert_dialog();
                return;
            } else {
                Toast.makeText(this, getResources().getString(R.string.please_select_atleast_one_course), 0).show();
                return;
            }
        }
        if (this.m_no.getText().toString().length() == 10) {
            if (this.m_no.getText().toString().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getMobile())) {
                Snackbar.make(view, getResources().getString(R.string.sorry_you_cant_tranfer_the_course_to_your_own_number), -1).show();
                return;
            } else {
                this.networkCall.NetworkAPICall(API.fetch_user, "", true, false);
                return;
            }
        }
        Snackbar.make(view, getResources().getString(R.string.please_enter_valid_mobile_number), -1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        Helper.backButtonClick(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2() {
        Helper.backButtonClick(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (this.course_list.size() > 0) {
            this.m_no.setEnabled(true);
            this.m_no.setText("");
            Iterator<Courselist> it = this.course_list.iterator();
            while (it.hasNext()) {
                it.next().setSelect(false);
            }
            this.refresh.setVisibility(8);
            this.buttonProceed.setText(getResources().getString(R.string.fetch_user));
            this.no_data_found_RL.setVisibility(8);
            this.course_name_recycler.setVisibility(8);
            this.buttonProceed.setBackground(getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
            return;
        }
        this.no_data_found_RL.setVisibility(0);
        this.course_name_recycler.setVisibility(8);
    }

    private void alert_dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.course_transfer));
        builder.setMessage(getResources().getString(R.string.are_you_sure_you_want_to_transfer_the_selected_course_to_below_mobile_number) + this.m_no.getText().toString() + "?");
        builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$alert_dialog$5(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$5(DialogInterface dialogInterface, int i) {
        this.networkCall.NetworkAPICall(API.transfer_course, "", true, false);
        dialogInterface.dismiss();
        dialogInterface.cancel();
    }

    private void showCouponCodePopup(final JSONObject jsonObject) {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime_frame5 < 1000) {
                return;
            }
            this.mLastClickTime_frame5 = SystemClock.elapsedRealtime();
            Dialog dialog = new Dialog(this);
            this.dialog = dialog;
            dialog.requestWindowFeature(1);
            this.dialog.setContentView(R.layout.monile_number_detlais);
            this.dialog.getWindow().setSoftInputMode(16);
            getWindow().setSoftInputMode(3);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.dialog.getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
            this.dialog.getWindow().setGravity(17);
            this.dialog.setCancelable(false);
            this.dialog.setCanceledOnTouchOutside(false);
            TextView textView = (TextView) this.dialog.findViewById(R.id.btn__cancel);
            TextView textView2 = (TextView) this.dialog.findViewById(R.id.user_name);
            TextView textView3 = (TextView) this.dialog.findViewById(R.id.user_email);
            TextView textView4 = (TextView) this.dialog.findViewById(R.id.user_mobile);
            CircleImageView circleImageView = (CircleImageView) this.dialog.findViewById(R.id.profileImage);
            TextView textView5 = (TextView) this.dialog.findViewById(R.id.btn_submit);
            textView2.setText(jsonObject.optString(getResources().getString(R.string.name)));
            textView3.setText(jsonObject.optString(getResources().getString(R.string.email)));
            textView4.setText(this.m_no.getText().toString());
            Glide.with((FragmentActivity) this).load(jsonObject.optString(Const.PROFILE_PICTURE)).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(circleImageView);
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$showCouponCodePopup$6(jsonObject, view);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    CourseTransferActivity courseTransferActivity = CourseTransferActivity.this;
                    courseTransferActivity.dismissCalculatorDialog(courseTransferActivity.dialog);
                }
            });
            this.dialog.show();
            this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    CourseTransferActivity.this.dialog.dismiss();
                    CourseTransferActivity.this.dialog.cancel();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCouponCodePopup$6(JSONObject jSONObject, View view) {
        dismissCalculatorDialog(this.dialog);
        this.refresh.setVisibility(0);
        this.m_no.setEnabled(false);
        this.m_no.setTag(jSONObject.optString("id"));
        this.course_name_recycler.setVisibility(0);
        this.buttonProceed.setText(getResources().getString(R.string.course_transfer));
        CourseSelectionAdapter courseSelectionAdapter = new CourseSelectionAdapter(this.course_list);
        this.courseSelectionAdapter = courseSelectionAdapter;
        this.course_name_recycler.setAdapter(courseSelectionAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissCalculatorDialog(Dialog watchlist) {
        if (watchlist == null || !watchlist.isShowing()) {
            return;
        }
        watchlist.dismiss();
        watchlist.cancel();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        int i;
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/users/search_user":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setMobile(this.m_no.getText().toString());
                return service.fetch_user(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/payment/transfer_course":
                ArrayList arrayList = new ArrayList();
                for (i = 0; i < this.noteDataArrayList.size(); i++) {
                    arrayList.add(this.noteDataArrayList.get(i).getTxn_id());
                }
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setTxn_ids(strArr);
                encryptionData2.setTransfer_to_id(this.m_no.getTag().toString());
                encryptionData2.setTransfer_to_mobile(this.m_no.getText().toString());
                encryptionData2.setResend("0");
                encryptionData2.setOtp("");
                return service.transfer_course(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_my_courses":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setIs_paid("1");
                return service.get_my_courses(AES.encrypt(new Gson().toJson(encryptionData3)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -1889532312:
                if (apitype.equals(API.fetch_user)) {
                    b2 = 0;
                }
                break;
            case 252416787:
                if (apitype.equals(API.transfer_course)) {
                    b2 = 1;
                }
                break;
            case 757992079:
                if (apitype.equals(API.get_my_courses)) {
                    b2 = 2;
                }
                break;
        }
        switch (b2) {
            case 0:
                try {
                    if (jsonstring.optString("status").equals("true")) {
                        JSONArray jSONArray = jsonstring.getJSONArray("data");
                        if (jSONArray.length() > 0) {
                            showCouponCodePopup(jSONArray.getJSONObject(0));
                        }
                    } else {
                        RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                break;
            case 1:
                try {
                    if (jsonstring.optString("status").equals("true")) {
                        Intent intent = new Intent(this, (Class<?>) OtpActivity.class);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < this.noteDataArrayList.size(); i++) {
                            arrayList.add(this.noteDataArrayList.get(i).getTxn_id());
                            arrayList2.add(this.noteDataArrayList.get(i).getId());
                        }
                        String[] strArr = new String[arrayList.size()];
                        String[] strArr2 = new String[arrayList2.size()];
                        String[] strArr3 = (String[]) arrayList.toArray(strArr);
                        String[] strArr4 = (String[]) arrayList2.toArray(strArr2);
                        intent.putExtra("coursestring", strArr3);
                        intent.putExtra("Transfer_to_id", this.m_no.getTag().toString());
                        intent.putExtra("Transfer_to_mobile", this.m_no.getText().toString());
                        intent.putExtra("c_ids", strArr4);
                        Helper.gotoActivity_finish(intent, this);
                    } else {
                        RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case 2:
                try {
                    if (jsonstring.optString("status").equals("true")) {
                        MyCourse myCourse = (MyCourse) new Gson().fromJson(jsonstring.toString(), MyCourse.class);
                        this.myCourse = myCourse;
                        if (myCourse.getData().size() > 0) {
                            ArrayList<Courselist> arrayList3 = new ArrayList<>();
                            this.course_list = arrayList3;
                            arrayList3.addAll(this.myCourse.getData());
                            if (this.course_list.size() > 0) {
                                this.no_data_found_RL.setVisibility(8);
                                this.course_name_recycler.setVisibility(8);
                                this.buttonProceed.setBackground(getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
                            } else {
                                this.no_data_found_RL.setVisibility(0);
                                this.course_name_recycler.setVisibility(8);
                                this.m_no.setEnabled(false);
                                this.buttonProceed.setEnabled(false);
                            }
                        }
                    } else {
                        this.no_data_found_RL.setVisibility(0);
                        this.course_name_recycler.setVisibility(8);
                        this.m_no.setEnabled(false);
                        this.buttonProceed.setEnabled(false);
                        RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
        }
    }

    public class CourseSelectionAdapter extends RecyclerView.Adapter<SubjectItemHolder> {
        ArrayList<Courselist> myNotesArrayList;

        public CourseSelectionAdapter(ArrayList<Courselist> myNotesArrayList) {
            this.myNotesArrayList = myNotesArrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SubjectItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SubjectItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.course_selection, parent, false));
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
            private final LinearLayout parentLL;
            private final TextView questiontextTV;
            private final CheckBox selectCB;

            public SubjectItemHolder(View itemView) {
                super(itemView);
                this.questiontextTV = (TextView) itemView.findViewById(R.id.questiontextTV);
                this.selectCB = (CheckBox) itemView.findViewById(R.id.selectCB);
                this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            }

            public void setSingleFAQData(ArrayList<Courselist> createTestSubjectsFinal, int pos) {
                final Courselist courselist = createTestSubjectsFinal.get(pos);
                this.questiontextTV.setText((pos + 1) + ". " + courselist.getTitle());
                if (courselist.isSelect()) {
                    this.selectCB.setChecked(true);
                } else {
                    this.selectCB.setChecked(false);
                }
                this.selectCB.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CourseTransfer.CourseTransferActivity$CourseSelectionAdapter$SubjectItemHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setSingleFAQData$0(courselist, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$setSingleFAQData$0(Courselist courselist, View view) {
                courselist.setSelect(!courselist.isSelect());
                CourseSelectionAdapter.this.checkProceedButton();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkProceedButton() {
            Iterator<Courselist> it = this.myNotesArrayList.iterator();
            while (it.hasNext() && !it.next().isSelect()) {
            }
        }
    }
}
