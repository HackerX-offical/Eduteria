package com.appnew.android.CourseTransfer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Sms.SmsBroadcastReceiver;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.VideosDownload;
import com.eduteria.app.app.R;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.firebase.database.DatabaseReference;
import com.google.gson.Gson;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class OtpActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnKeyListener, TextWatcher, NetworkCall.MyNetworkCallBack {
    private static final int REQ_USER_CONSENT = 200;
    BroadcastReceiver broadcastReceiver;
    String[] c_ids;
    public DatabaseReference firebaseDatabase;
    ImageView iv_back;
    long leftmillisUntilFinished;
    private EditText mPinFirstDigitEditText;
    private EditText mPinForthDigitEditText;
    private EditText mPinHiddenEditText;
    private EditText mPinSecondDigitEditText;
    private EditText mPinThirdDigitEditText;
    private EditText mPinfifthDigitEditText;
    private EditText mPinsixthDigitEditText;
    private TextView mresendotpTV;
    private TextView mresendotpTV1;
    NetworkCall networkCall;
    SmsBroadcastReceiver smsBroadcastReceiver;
    String[] strings;
    private TextView tvTimer;
    int type;
    Data user;
    Button verifyBtn;
    private TextView verifyTextTV;
    String otp = "";
    boolean isresend = false;
    String otptext = "";
    String userID = "";
    String isReg = "0";
    int requestCode = -1;
    private boolean resetPass = false;
    private boolean isChangePass = false;
    private boolean isphone = false;
    boolean status = false;
    private CountDownTimer countDownTimer = null;
    String transfer_to = "";
    String transfer_from = "";
    ActivityResultLauncher<Intent> otplauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.CourseTransfer.OtpActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$5((ActivityResult) obj);
        }
    });
    ActivityResultLauncher<Intent> otplaunche = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.appnew.android.CourseTransfer.OtpActivity.4
        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(ActivityResult result) {
            if (OtpActivity.this.requestCode == 200) {
                if (result.getResultCode() == -1 && result.getData() != null) {
                    OtpActivity.this.getOtpFromMessage(result.getData().getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE));
                    return;
                }
                OtpActivity.this.mPinFirstDigitEditText.setEnabled(true);
                OtpActivity.this.mPinSecondDigitEditText.setEnabled(true);
                OtpActivity.this.mPinThirdDigitEditText.setEnabled(true);
                OtpActivity.this.mPinForthDigitEditText.setEnabled(true);
                OtpActivity.this.mPinfifthDigitEditText.setEnabled(true);
                OtpActivity.this.mPinsixthDigitEditText.setEnabled(true);
            }
        }
    });

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.otp_activity);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            this.networkCall = new NetworkCall(this, this);
            SmsRetriever.getClient((Activity) this).startSmsUserConsent(null);
            this.strings = getIntent().getStringArrayExtra("coursestring");
            this.c_ids = getIntent().getStringArrayExtra("c_ids");
            this.transfer_to = getIntent().getStringExtra("Transfer_to_id");
            this.transfer_from = getIntent().getStringExtra("Transfer_to_mobile");
            this.mPinFirstDigitEditText = (EditText) findViewById(R.id.OPT1ET);
            this.mPinSecondDigitEditText = (EditText) findViewById(R.id.OPT2ET);
            this.mPinThirdDigitEditText = (EditText) findViewById(R.id.OPT3ET);
            this.mPinForthDigitEditText = (EditText) findViewById(R.id.OPT4ET);
            this.mPinfifthDigitEditText = (EditText) findViewById(R.id.OPT5ET);
            this.mPinsixthDigitEditText = (EditText) findViewById(R.id.OPT6ET);
            this.mPinHiddenEditText = (EditText) findViewById(R.id.pin_hidden_edittext);
            this.mresendotpTV1 = (TextView) findViewById(R.id.resendotpTV1);
            this.mresendotpTV = (TextView) findViewById(R.id.resendotpTV);
            this.verifyTextTV = (TextView) findViewById(R.id.verifyTextTV);
            this.iv_back = (ImageView) findViewById(R.id.iv_back);
            this.verifyBtn = (Button) findViewById(R.id.verifyBtn);
            this.tvTimer = (TextView) findViewById(R.id.tv_timer);
            setPINListeners();
            this.iv_back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CourseTransfer.OtpActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    OtpActivity.this.finish();
                }
            });
            this.verifyBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.CourseTransfer.OtpActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$0();
                }
            }));
            this.mresendotpTV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.CourseTransfer.OtpActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$1();
                }
            }));
            TextView textView = this.tvTimer;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            setTimer();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        String strTrim = this.mPinHiddenEditText.getText().toString().trim();
        this.otptext = strTrim;
        if (TextUtils.isEmpty(strTrim)) {
            Toast.makeText(this, getResources().getString(R.string.otp_does_not_blank), 0).show();
            return null;
        }
        this.otp = this.otptext;
        this.networkCall.NetworkAPICall(API.transfer_course, "", true, false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        this.isresend = true;
        this.otp = "";
        this.networkCall.NetworkAPICall(API.transfer_course, "", true, false);
        return null;
    }

    public void alert_dailog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.course_transfer));
        builder.setMessage(getResources().getString(R.string.are_you_sure_you_want_to_transfer_the_selected_course_to_below_mobile_number) + this.transfer_from + "?");
        builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.CourseTransfer.OtpActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.CourseTransfer.OtpActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$alert_dailog$3(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dailog$3(DialogInterface dialogInterface, int i) {
        this.networkCall.NetworkAPICall(API.transfer_course, "", true, false);
        dialogInterface.dismiss();
        dialogInterface.cancel();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.transfer_course)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setTxn_ids(this.strings);
        encryptionData.setTransfer_to_id(this.transfer_to);
        encryptionData.setTransfer_to_mobile(this.transfer_from);
        if (this.isresend) {
            encryptionData.setOtp(this.otp);
            encryptionData.setResend("1");
        } else {
            encryptionData.setOtp(this.otp);
            encryptionData.setResend("0");
        }
        return service.transfer_course(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonString, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.transfer_course)) {
            try {
                if (jsonString.optString("status").equals("true")) {
                    Toast.makeText(this, "" + jsonString.optString("message"), 0).show();
                    if (this.isresend) {
                        claerdata();
                        setTimer();
                        this.isresend = false;
                        return;
                    }
                    CountDownTimer countDownTimer = this.countDownTimer;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
                    for (String str : this.c_ids) {
                        appDatabase.getuserhistorydao().delete(str + MqttTopic.MULTI_LEVEL_WILDCARD, MakeMyExam.userId);
                        List<VideosDownload> list = appDatabase.getvideoDownloadao().getallcourse_id(str + MqttTopic.MULTI_LEVEL_WILDCARD, MakeMyExam.userId);
                        if (list != null && list.size() > 0) {
                            for (VideosDownload videosDownload : list) {
                                File file = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                                File file2 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADING_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                                if (file.exists()) {
                                    file.delete();
                                }
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                appDatabase.getvideoDownloadao().delete(videosDownload.getVideo_id(), videosDownload.getCourse_id(), MakeMyExam.userId);
                            }
                        }
                    }
                    finish();
                    return;
                }
                RetrofitResponse.GetApiData(this, jsonString.has("auth_code") ? jsonString.getString("auth_code") : "", jsonString.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void claerdata() {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.CourseTransfer.OtpActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$claerdata$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$claerdata$4() {
        this.mPinHiddenEditText.getText().clear();
        this.mPinFirstDigitEditText.getText().clear();
        this.mPinSecondDigitEditText.getText().clear();
        this.mPinThirdDigitEditText.getText().clear();
        this.mPinForthDigitEditText.getText().clear();
        this.mPinfifthDigitEditText.getText().clear();
        this.mPinsixthDigitEditText.getText().clear();
        this.mPinFirstDigitEditText.setEnabled(true);
        this.mPinSecondDigitEditText.setEnabled(true);
        this.mPinThirdDigitEditText.setEnabled(true);
        this.mPinForthDigitEditText.setEnabled(true);
        this.mPinfifthDigitEditText.setEnabled(true);
        this.mPinsixthDigitEditText.setEnabled(true);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        if (s.length() == 0) {
            this.mPinFirstDigitEditText.setText("");
            return;
        }
        if (s.length() == 1) {
            this.mPinFirstDigitEditText.setText(s.charAt(0) + "");
            this.mPinSecondDigitEditText.setText("");
            this.mPinThirdDigitEditText.setText("");
            this.mPinForthDigitEditText.setText("");
            this.mPinfifthDigitEditText.setText("");
            this.mPinsixthDigitEditText.setText("");
            return;
        }
        if (s.length() == 2) {
            this.mPinSecondDigitEditText.setText(s.charAt(1) + "");
            this.mPinThirdDigitEditText.setText("");
            this.mPinForthDigitEditText.setText("");
            this.mPinfifthDigitEditText.setText("");
            this.mPinsixthDigitEditText.setText("");
            return;
        }
        if (s.length() == 3) {
            this.mPinThirdDigitEditText.setText(s.charAt(2) + "");
            this.mPinForthDigitEditText.setText("");
            this.mPinfifthDigitEditText.setText("");
            this.mPinsixthDigitEditText.setText("");
            return;
        }
        if (s.length() == 4) {
            this.mPinForthDigitEditText.setText(s.charAt(3) + "");
            this.mPinfifthDigitEditText.setText("");
            this.mPinsixthDigitEditText.setText("");
        } else if (s.length() == 5) {
            this.mPinfifthDigitEditText.setText(s.charAt(4) + "");
            this.mPinsixthDigitEditText.setText("");
        } else if (s.length() == 6) {
            this.mPinsixthDigitEditText.setText(s.charAt(5) + "");
            hideSoftKeyboard(this.mPinsixthDigitEditText);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            SmsBroadcastReceiver smsBroadcastReceiver = this.smsBroadcastReceiver;
            if (smsBroadcastReceiver != null) {
                unregisterReceiver(smsBroadcastReceiver);
            }
        } catch (Exception e2) {
            Log.d("onStop", "onStop: " + e2.getMessage());
        }
        getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    public void hideSoftKeyboard(EditText editText) {
        if (editText == null) {
            return;
        }
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void setPINListeners() {
        this.mPinHiddenEditText.addTextChangedListener(this);
        this.mPinFirstDigitEditText.setOnFocusChangeListener(this);
        this.mPinSecondDigitEditText.setOnFocusChangeListener(this);
        this.mPinThirdDigitEditText.setOnFocusChangeListener(this);
        this.mPinForthDigitEditText.setOnFocusChangeListener(this);
        this.mPinfifthDigitEditText.setOnFocusChangeListener(this);
        this.mPinsixthDigitEditText.setOnFocusChangeListener(this);
        this.mPinFirstDigitEditText.setOnKeyListener(this);
        this.mPinSecondDigitEditText.setOnKeyListener(this);
        this.mPinThirdDigitEditText.setOnKeyListener(this);
        this.mPinForthDigitEditText.setOnKeyListener(this);
        this.mPinfifthDigitEditText.setOnKeyListener(this);
        this.mPinsixthDigitEditText.setOnKeyListener(this);
        this.mPinHiddenEditText.setOnKeyListener(this);
    }

    public void showSoftKeyboard(EditText editText) {
        if (editText == null) {
            return;
        }
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(editText, 0);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean hasFocus) {
        switch (view.getId()) {
            case R.id.OPT1ET /* 2131361873 */:
                if (hasFocus) {
                    setFocus(this.mPinHiddenEditText);
                    showSoftKeyboard(this.mPinHiddenEditText);
                }
                break;
            case R.id.OPT2ET /* 2131361874 */:
                if (hasFocus) {
                    setFocus(this.mPinHiddenEditText);
                    showSoftKeyboard(this.mPinHiddenEditText);
                }
                break;
            case R.id.OPT3ET /* 2131361875 */:
                if (hasFocus) {
                    setFocus(this.mPinHiddenEditText);
                    showSoftKeyboard(this.mPinHiddenEditText);
                }
                break;
            case R.id.OPT4ET /* 2131361876 */:
                if (hasFocus) {
                    setFocus(this.mPinHiddenEditText);
                    showSoftKeyboard(this.mPinHiddenEditText);
                }
                break;
            case R.id.OPT5ET /* 2131361877 */:
                if (hasFocus) {
                    setFocus(this.mPinHiddenEditText);
                    showSoftKeyboard(this.mPinHiddenEditText);
                }
                break;
            case R.id.OPT6ET /* 2131361878 */:
                if (hasFocus) {
                    setFocus(this.mPinHiddenEditText);
                    showSoftKeyboard(this.mPinHiddenEditText);
                }
                break;
        }
    }

    public static void setFocus(EditText editText) {
        if (editText == null) {
            return;
        }
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && view.getId() == R.id.pin_hidden_edittext && keyCode == 67) {
            if (this.mPinHiddenEditText.getText().length() == 6) {
                this.mPinsixthDigitEditText.setText("");
            } else if (this.mPinHiddenEditText.getText().length() == 5) {
                this.mPinfifthDigitEditText.setText("");
            } else if (this.mPinHiddenEditText.getText().length() == 4) {
                this.mPinForthDigitEditText.setText("");
            } else if (this.mPinHiddenEditText.getText().length() == 3) {
                this.mPinThirdDigitEditText.setText("");
            } else if (this.mPinHiddenEditText.getText().length() == 2) {
                this.mPinSecondDigitEditText.setText("");
            } else if (this.mPinHiddenEditText.getText().length() == 1) {
                this.mPinFirstDigitEditText.setText("");
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == -1 && data != null) {
                getOtpFromMessage(data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE));
                return;
            }
            this.mPinFirstDigitEditText.setEnabled(true);
            this.mPinSecondDigitEditText.setEnabled(true);
            this.mPinThirdDigitEditText.setEnabled(true);
            this.mPinForthDigitEditText.setEnabled(true);
            this.mPinfifthDigitEditText.setEnabled(true);
            this.mPinsixthDigitEditText.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOtpFromMessage(String message) {
        if (message == null || message.equalsIgnoreCase("") || !Pattern.compile("(|^)\\d{6}").matcher(message).find()) {
            return;
        }
        String code = parseCode(message);
        this.otptext = code;
        this.mPinHiddenEditText.setText(code);
        this.mPinFirstDigitEditText.setText(String.valueOf(this.otptext.charAt(0)));
        this.mPinSecondDigitEditText.setText(String.valueOf(this.otptext.charAt(1)));
        this.mPinThirdDigitEditText.setText(String.valueOf(this.otptext.charAt(2)));
        this.mPinForthDigitEditText.setText(String.valueOf(this.otptext.charAt(3)));
        this.mPinfifthDigitEditText.setText(String.valueOf(this.otptext.charAt(4)));
        this.mPinsixthDigitEditText.setText(String.valueOf(this.otptext.charAt(5)));
        this.mPinFirstDigitEditText.setEnabled(true);
        this.mPinSecondDigitEditText.setEnabled(true);
        this.mPinThirdDigitEditText.setEnabled(true);
        this.mPinForthDigitEditText.setEnabled(true);
        this.mPinfifthDigitEditText.setEnabled(true);
        this.mPinsixthDigitEditText.setEnabled(true);
        this.otp = this.otptext;
    }

    private String parseCode(String message) {
        Matcher matcher = Pattern.compile("\\b\\d{6}\\b").matcher(message);
        String strGroup = "";
        while (matcher.find()) {
            strGroup = matcher.group(0);
        }
        return strGroup;
    }

    public void setTimer() {
        this.status = true;
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(60000L, 1000L) { // from class: com.appnew.android.CourseTransfer.OtpActivity.2
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                try {
                    OtpActivity.this.tvTimer.setVisibility(0);
                    OtpActivity.this.mresendotpTV1.setVisibility(8);
                    OtpActivity.this.mresendotpTV.setVisibility(8);
                    OtpActivity.this.tvTimer.setText("0" + String.format("%d:%d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))));
                    OtpActivity.this.leftmillisUntilFinished = millisUntilFinished;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                try {
                    OtpActivity.this.status = false;
                    OtpActivity.this.tvTimer.setText("");
                    OtpActivity.this.tvTimer.setVisibility(8);
                    OtpActivity.this.mresendotpTV.setVisibility(0);
                    OtpActivity.this.mresendotpTV1.setVisibility(0);
                } catch (Exception unused) {
                }
            }
        };
        this.countDownTimer = countDownTimer2;
        countDownTimer2.start();
    }

    private void registerBroadcastReceiver() {
        try {
            SmsBroadcastReceiver smsBroadcastReceiver = new SmsBroadcastReceiver();
            this.smsBroadcastReceiver = smsBroadcastReceiver;
            smsBroadcastReceiver.setSmsBroadcastReceiverListener(new SmsBroadcastReceiver.SmsBroadcastReceiverListener() { // from class: com.appnew.android.CourseTransfer.OtpActivity.3
                @Override // com.appnew.android.Sms.SmsBroadcastReceiver.SmsBroadcastReceiverListener
                public void onFailure() {
                }

                @Override // com.appnew.android.Sms.SmsBroadcastReceiver.SmsBroadcastReceiverListener
                public void onSuccess(Intent intent) {
                    if (intent != null) {
                        OtpActivity.this.otplauncher.launch(intent);
                    } else {
                        OtpActivity.this.otplauncher.launch(new Intent());
                    }
                }
            });
            IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
            SmsBroadcastReceiver smsBroadcastReceiver2 = this.smsBroadcastReceiver;
            if (smsBroadcastReceiver2 != null) {
                ContextCompat.registerReceiver(this, smsBroadcastReceiver2, intentFilter, 2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(ActivityResult activityResult) {
        if (this.requestCode == 200) {
            if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
                getOtpFromMessage(activityResult.getData().getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE));
                return;
            }
            this.mPinFirstDigitEditText.setEnabled(true);
            this.mPinSecondDigitEditText.setEnabled(true);
            this.mPinThirdDigitEditText.setEnabled(true);
            this.mPinForthDigitEditText.setEnabled(true);
            this.mPinfifthDigitEditText.setEnabled(true);
            this.mPinsixthDigitEditText.setEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        registerBroadcastReceiver();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        this.mPinFirstDigitEditText.setEnabled(true);
        this.mPinSecondDigitEditText.setEnabled(true);
        this.mPinThirdDigitEditText.setEnabled(true);
        this.mPinForthDigitEditText.setEnabled(true);
        this.mPinfifthDigitEditText.setEnabled(true);
        this.mPinsixthDigitEditText.setEnabled(true);
    }
}
