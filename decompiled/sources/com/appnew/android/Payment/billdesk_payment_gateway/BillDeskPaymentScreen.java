package com.appnew.android.Payment.billdesk_payment_gateway;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.pojo.Userinfo.Data;
import com.billdesk.sdk.PaymentOptions;

/* JADX INFO: loaded from: classes6.dex */
public class BillDeskPaymentScreen extends AppCompatActivity {
    String strPGMsg = "AIRMTST|ARP1669122017340|NA|2|NA|NA|NA|INR|NA|R|airmtst|NA|NA|F|NA|NA|NA|NA|NA|NA|NA|https://uat.billdesk.com/pgidsk/pgmerc/pg_dump.jsp|3208316534";
    String strTokenMsg = null;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        SampleCallBack sampleCallBack = new SampleCallBack();
        if (getIntent() == null) {
            stringExtra = "";
        } else {
            stringExtra = getIntent().getStringExtra("txnToken");
        }
        Intent intent = new Intent(this, (Class<?>) PaymentOptions.class);
        intent.putExtra("msg", stringExtra);
        String str = this.strTokenMsg;
        if (str != null && str.length() > this.strPGMsg.length()) {
            intent.putExtra("token", this.strTokenMsg);
        }
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        intent.putExtra("user-email", loggedInUser.getEmail());
        intent.putExtra("user-mobile", loggedInUser.getMobile());
        intent.putExtra("callback", sampleCallBack);
        startActivity(intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SharedPreference.getInstance().putString("paymentResult", null);
        super.onBackPressed();
    }
}
