package com.billdesk.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.ResultWrapper;
import com.billdesk.utils.URLUtilActivity;
import com.clevertap.android.sdk.Constants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Emerald2Activity extends BaseClass {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, Object> f384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f386d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f390h;
    public String i;
    public String j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f383a = Emerald2Activity.class.getName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f387e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f388f = Boolean.FALSE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f389g = "";

    public final void b(String str) {
        String str2 = "DeepLink JSON: " + str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f389g = jSONObject.getJSONObject("data").getString("bank_deep_link");
            this.f390h = jSONObject.getJSONObject("data").getString("uuid");
            this.i = jSONObject.getJSONObject("data").getString("txnid");
            this.j = jSONObject.getJSONObject("data").getString("responseURL");
            String str3 = "invokeDeepLink:- " + this.f389g;
            String str4 = "UUID:- " + this.f390h;
            String str5 = "TxnID:- " + this.i;
            String str6 = "ResponseURL:- " + this.j;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f389g));
            if (getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
                Helper.a("Please ensure you have the latest version of the Mobile Banking Application installed and try again.", (Context) this, true);
            } else {
                startActivityForResult(intent, 111);
                this.f388f = Boolean.TRUE;
            }
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
            Helper.a("Please ensure you have the latest version of the Mobile Banking Application installed and try again.", (Context) this, true);
        } catch (Exception e3) {
            e3.printStackTrace();
            Helper.a("Unable to open Mobile Banking Application. Please ensure you have the latest version of the Mobile Banking Application installed and try again.", (Context) this, true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        super.onActivityResult(i, i2, intent);
        String str2 = "onActivityResult: resultcode" + i2 + ", requestcode : " + i;
        switch (i) {
            case 109:
                try {
                    if (intent != null) {
                        this.f387e = ((ResultWrapper) intent.getSerializableExtra("data")).f531c;
                    } else {
                        Helper.a("No data received while getting DeepLink", (Context) this, true);
                    }
                    String str3 = "DataString" + this.f387e;
                    String str4 = this.f387e;
                    if (str4 == null || str4.length() <= 0) {
                        Helper.a("There was an error initiating the payment. Please try again.", (Context) this, true);
                    } else if (!this.f388f.booleanValue()) {
                        b(this.f387e);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 110:
                String str5 = "onActivityResult- Got result - Emerald2CheckTxnStatusRequest : " + this.f387e;
                try {
                    if (intent != null) {
                        this.f387e = intent.getStringExtra("data");
                    } else {
                        Helper.a("No data received while checking Emerald txn status", (Context) this, true);
                    }
                    String str6 = this.f387e;
                    if (str6 == null || str6.length() <= 0) {
                        str = "Error communicating with Payment Server";
                    } else if (PaymentLibConstants.u != null) {
                        PaymentLibConstants.u.paymentStatus(this.f387e, this);
                    } else {
                        str = "Technical Error. Code 10010";
                    }
                    Helper.a(str, (Context) this, true);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case 111:
                Intent intent2 = new Intent(this, (Class<?>) URLUtilActivity.class);
                intent2.putExtra("req_type", 110);
                intent2.putExtra("url", this.j);
                this.f384b = null;
                HashMap<String, Object> map = new HashMap<>();
                this.f384b = map;
                map.put("uuid", this.f390h);
                this.f384b.put("txnid", this.i);
                String str7 = "uuid & txnid ==" + this.f390h + " & " + this.i;
                intent2.putExtra("paymentDetail", this.f384b);
                startActivityForResult(intent2, 110);
                break;
        }
    }

    @Override // com.billdesk.sdk.BaseClass, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f387e = extras.getString("dataStr");
        }
        Helper.c(this);
        requestWindowFeature(1);
        this.f386d = (int) (getResources().getDisplayMetrics().density * 10.0f);
        ScrollView scrollView = new ScrollView(this);
        LinearLayout linearLayoutA = Helper.a((Activity) this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayoutA.addView(Helper.a("", (Activity) this));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this);
        textView.setText("Emerald Pay");
        textView.setGravity(17);
        textView.setTextSize(2, 20.0f);
        int i = this.f386d;
        textView.setPadding(i / 2, i, 0, 0);
        Helper.a(textView, false, (Activity) this);
        linearLayout.addView(textView);
        linearLayoutA.addView(linearLayout);
        scrollView.setFillViewport(true);
        scrollView.addView(linearLayoutA);
        setContentView(scrollView);
        this.f384b = (HashMap) extras.get("paymentDetail");
        String str = "onCreate- Emerald2 valmap is [" + this.f384b.toString() + "] and bundle is [" + extras.toString() + Constants.AES_SUFFIX;
        String str2 = "onCreate- credit msg is " + this.f384b.get("msg").toString();
        this.f385c = extras.getString("url");
        String str3 = "onCreate- redirectUrl is " + this.f385c;
        Intent intent = new Intent(this, (Class<?>) URLUtilActivity.class);
        intent.putExtra("req_type", 109);
        intent.putExtra("paymentDetail", this.f384b);
        intent.putExtra("url", this.f385c);
        startActivityForResult(intent, 109);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String str = "onRestoreInstanceState running = " + bundle.getString("dataStr");
        PaymentLibConstants.u = (LibraryPaymentStatusProtocol) bundle.getParcelable("paymentStatusProtocol");
        this.f387e = bundle.getString("dataStr");
        this.f390h = bundle.getString("strUUID");
        this.i = bundle.getString("strTxnID");
        this.j = bundle.getString("strResponseURL");
        this.f388f = Boolean.valueOf(bundle.getBoolean("isOpenMobileApp"));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("paymentStatusProtocol", PaymentLibConstants.u);
        bundle.putString("dataStr", this.f387e);
        bundle.putString("strUUID", this.f390h);
        bundle.putString("strTxnID", this.i);
        bundle.putString("strResponseURL", this.j);
        bundle.putBoolean("isOpenMobileApp", this.f388f.booleanValue());
    }
}
