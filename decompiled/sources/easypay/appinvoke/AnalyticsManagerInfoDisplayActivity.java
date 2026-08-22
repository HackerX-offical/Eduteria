package easypay.appinvoke;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Utils.Const;
import java.util.HashMap;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class AnalyticsManagerInfoDisplayActivity extends AppCompatActivity {
    protected HashMap<String, Object> mEventMap;
    private TextView mTvAcsUrl;
    private TextView mTvAcsUrlLoaded;
    private TextView mTvAcsUrlRequested;
    private TextView mTvAppName;
    private TextView mTvCardType;
    private TextView mTvCardUser;
    private TextView mTvIsAssistEnabled;
    private TextView mTvIsAssistPopped;
    private TextView mTvIsSmsRead;
    private TextView mTvIsSubmitted;
    private TextView mTvMid;
    private TextView mTvOrderId;
    private TextView mTvOtp;
    private TextView mTvSender;
    private TextView mTvSmspermission;
    private TextView mTvredirectUrl;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_analytics_manager_info_display);
        this.mEventMap = (HashMap) getIntent().getExtras().getSerializable("data");
        initView();
        setValues();
    }

    private void setValues() {
        HashMap<String, Object> map = this.mEventMap;
        if (map != null) {
            this.mTvredirectUrl.setText(map.get("redirectUrls").toString());
            this.mTvMid.setText(this.mEventMap.get("mid").toString());
            this.mTvCardType.setText(this.mEventMap.get("cardType").toString());
            this.mTvOrderId.setText(this.mEventMap.get("orderId").toString());
            this.mTvAcsUrlRequested.setText(this.mEventMap.get("acsUrlRequested").toString());
            this.mTvCardUser.setText(this.mEventMap.get("cardIssuer").toString());
            this.mTvAppName.setText(this.mEventMap.get("appName").toString());
            this.mTvSmspermission.setText(this.mEventMap.get("smsPermission").toString());
            this.mTvIsSubmitted.setText(this.mEventMap.get("isSubmitted").toString());
            this.mTvAcsUrl.setText(this.mEventMap.get("acsUrl").toString());
            this.mTvIsSmsRead.setText(this.mEventMap.get("isSMSRead").toString());
            this.mTvIsAssistEnabled.setText(this.mEventMap.get("mid").toString());
            this.mTvOtp.setText(this.mEventMap.get(Const.OTP).toString());
            this.mTvAcsUrlLoaded.setText(this.mEventMap.get("acsUrlLoaded").toString());
            this.mTvSender.setText(this.mEventMap.get("sender").toString());
            this.mTvIsAssistPopped.setText(this.mEventMap.get("isAssistPopped").toString());
        }
    }

    private void initView() {
        this.mTvredirectUrl = (TextView) findViewById(R.id.tv_RedirectUrls);
        this.mTvMid = (TextView) findViewById(R.id.tv_mid);
        this.mTvCardType = (TextView) findViewById(R.id.tv_cardType);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_RedirectUrls);
        this.mTvAcsUrlRequested = (TextView) findViewById(R.id.tv_acsUrlRequested);
        this.mTvCardUser = (TextView) findViewById(R.id.tv_cardIssuer);
        this.mTvAppName = (TextView) findViewById(R.id.tv_appName);
        this.mTvSmspermission = (TextView) findViewById(R.id.tv_smsPermission);
        this.mTvIsSubmitted = (TextView) findViewById(R.id.tv_isSubmitted);
        this.mTvAcsUrl = (TextView) findViewById(R.id.tv_acsUrl);
        this.mTvIsSmsRead = (TextView) findViewById(R.id.tv_isSMSRead);
        this.mTvIsAssistEnabled = (TextView) findViewById(R.id.tv_isAssistEnable);
        this.mTvOtp = (TextView) findViewById(R.id.tv_otp);
        this.mTvAcsUrlLoaded = (TextView) findViewById(R.id.tv_acsUrlLoaded);
        this.mTvSender = (TextView) findViewById(R.id.tv_sender);
        this.mTvIsAssistPopped = (TextView) findViewById(R.id.tv_isAssistPopped);
    }
}
