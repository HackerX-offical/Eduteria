package com.billdesk.sdk;

import a.a.c.q;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.exifinterface.media.ExifInterface;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.ResultWrapper;
import com.billdesk.utils.SecurePreferences;
import com.billdesk.utils.URLUtilActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Iterator;
import org.bouncycastle.i18n.ErrorBundle;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class UpiActivity extends BaseClass {
    public ProgressDialog A;
    public String B;
    public boolean D;
    public String E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f468f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f470h;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public EditText t;
    public Spinner u;
    public Handler y;
    public HandlerThread z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f469g = "";
    public int i = 0;
    public String[] v = null;
    public int w = 0;
    public String x = "tag";
    public String C = "";

    public static void a(UpiActivity upiActivity) {
        upiActivity.y.sendEmptyMessageDelayed(11, Integer.parseInt(upiActivity.f465c.getString("UPI_Status_Polling_Interval")) * 1000);
    }

    public final void b() throws JSONException {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("upi://pay"));
        if (!Helper.a(this.f465c.optString("PSP_app_package_name")).equals("NA")) {
            intent.setPackage(this.f465c.optString("PSP_app_package_name"));
        }
        if (getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
            if (this.f465c.has("PSP_app_package_name") && !Helper.a(this.f465c.getString("PSP_app_package_name")).equals("NA")) {
                try {
                    getPackageManager().getApplicationInfo(this.f465c.getString("PSP_app_package_name"), 0);
                } catch (Exception unused) {
                }
            }
            e();
            return;
        }
        c();
    }

    public final boolean b(String str) {
        String string;
        StringBuilder sb;
        String str2 = "Response Data checkErrorStatus : " + str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if ((jSONObject2.has("error_message") && jSONObject2.optString("error_message").equalsIgnoreCase("Success")) || jSONObject2.optString("BRN").length() > 2) {
                return true;
            }
            Intent intent = new Intent(this, (Class<?>) PaymentWebView.class);
            this.f463a = new HashMap<>();
            intent.putExtra("url", jSONObject.optString("url"));
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                this.f463a.put(next, jSONObject2.optString(next));
            }
            intent.putExtra("paymentDetail", this.f463a);
            startActivity(intent);
            finish();
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f470h = new SecurePreferences(getApplicationContext()).getBoolean(PaymentLibConstants.f511b + "_cid_unique", false);
            ProgressDialog progressDialog = this.A;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            String str3 = "CID_Unique : " + this.f470h;
            if (this.f470h) {
                PaymentLibConstants.f516g = true;
                string = getResources().getString(R.string.ERR46);
                sb = new StringBuilder("Error Message : ");
            } else {
                PaymentLibConstants.f516g = false;
                string = getResources().getString(R.string.ERR46);
                sb = new StringBuilder("Error Message in else : ");
            }
            sb.append(string).toString();
            Helper.a(string, (Context) this, true);
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(1:4)(1:5)|6|(2:8|(10:13|16|39|17|(3:19|20|(1:30)(7:24|(2:27|25)|41|28|29|37|38))(1:32)|31|33|29|37|38)(1:12))(1:14)|15|16|39|17|(0)(0)|31|33|29|37|38) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0449, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x044a, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x035c A[Catch: Exception -> 0x0449, TRY_LEAVE, TryCatch #0 {Exception -> 0x0449, blocks: (B:17:0x0354, B:19:0x035c, B:22:0x036e, B:24:0x0374, B:25:0x03fd, B:27:0x0403, B:28:0x0415, B:29:0x0431, B:30:0x0435, B:31:0x043a, B:33:0x0443, B:32:0x043d), top: B:39:0x0354 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x043d A[Catch: Exception -> 0x0449, TryCatch #0 {Exception -> 0x0449, blocks: (B:17:0x0354, B:19:0x035c, B:22:0x036e, B:24:0x0374, B:25:0x03fd, B:27:0x0403, B:28:0x0415, B:29:0x0431, B:30:0x0435, B:31:0x043a, B:33:0x0443, B:32:0x043d), top: B:39:0x0354 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instruction units count: 1208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.billdesk.sdk.UpiActivity.c():void");
    }

    public final void c(String str) {
        try {
            d(str);
            if (this.D) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            String str2 = "Tez UPI JSON: " + str;
            stringBuffer.append("upi://pay?pa=" + this.j);
            stringBuffer.append("&pn=" + this.k);
            stringBuffer.append("&mc=" + this.l);
            stringBuffer.append("&tr=" + this.m);
            stringBuffer.append("&tn=" + this.n);
            stringBuffer.append("&am=" + this.o);
            stringBuffer.append("&cu=" + this.p);
            stringBuffer.append("&url=" + this.s);
            String str3 = "str_pa :- " + this.j;
            String str4 = "str_pn :- " + this.k;
            String str5 = "str_mc :- " + this.l;
            String str6 = "str_tr :- " + this.m;
            String str7 = "str_tn :- " + this.n;
            String str8 = "str_am :- " + this.o;
            String str9 = "str_cu :- " + this.p;
            String str10 = "str_BRN :- " + this.q;
            String str11 = "str_url :- " + this.s;
            String string = stringBuffer.toString();
            String str12 = "UPIPayLink:- " + string;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(string));
            if (!Helper.a(this.f465c.optString("PSP_app_package_name")).equals("NA")) {
                intent.setPackage(this.f465c.optString("PSP_app_package_name"));
            }
            if (getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) {
                c();
            } else {
                this.D = true;
                startActivityForResult(intent, 22);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.A = progressDialog;
        progressDialog.setCancelable(false);
        String strReplace = getResources().getString(R.string.upi_progress_msg).replace("@upi", this.E);
        String str = "upi_progress_msg====" + strReplace;
        this.A.setMessage(Html.fromHtml(strReplace));
        this.A.show();
        d(this.C);
    }

    public final void d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getJSONObject("data");
            this.j = jSONObject.getJSONObject("data").optString("pa");
            this.k = jSONObject.getJSONObject("data").optString("pn");
            this.l = jSONObject.getJSONObject("data").optString("mc");
            this.m = jSONObject.getJSONObject("data").optString("tr");
            this.n = jSONObject.getJSONObject("data").optString("tn");
            this.o = jSONObject.getJSONObject("data").optString("am");
            jSONObject.getJSONObject("data").optString("mam");
            this.p = jSONObject.getJSONObject("data").optString("cu");
            this.q = jSONObject.getJSONObject("data").optString("BRN");
            this.r = jSONObject.getJSONObject("data").optString("ru");
            String string = jSONObject.getString("url");
            this.s = string;
            if (string.length() > 35) {
                this.s = this.s.substring(0, 35);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e() {
        String str = "Upi Activity Data String: " + this.C;
        String str2 = this.C;
        if (str2 != null && !str2.isEmpty()) {
            c(this.C);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) URLUtilActivity.class);
        intent.putExtra("req_type", 12541);
        intent.putExtra("paymentDetail", this.f463a);
        intent.putExtra("url", this.f464b.optString("redirect-url"));
        startActivityForResult(intent, 12541);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            try {
                extras = intent.getExtras();
            } catch (Exception e2) {
                Log.e(this.x, e2.getMessage());
                Helper.a("Encounter error while processing your request", (Context) this, true);
                return;
            }
        } else {
            extras = null;
        }
        if (i == 22) {
            try {
                this.D = false;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("Status", "SUCCESS");
                jSONObject2.put("responseCode", ExifInterface.LATITUDE_SOUTH);
                jSONObject2.put("TrtxnRef", this.m);
                jSONObject2.put("ApprovalRefNo", "");
                jSONObject2.put("signatureKeyId", "");
                jSONObject2.put("txnRef", this.m);
                jSONObject2.put("signature", "");
                jSONObject2.put("txnId", "");
                jSONObject.put(ErrorBundle.DETAIL_ENTRY, jSONObject2);
                jSONObject.put("methodName", "https:\\\\tez.google.com\\pay");
                HashMap map = new HashMap();
                map.put("bankres", Base64.encodeToString(jSONObject.toString().getBytes(), 0));
                map.put("BRN", this.q);
                Intent intent2 = new Intent(this, (Class<?>) PaymentWebView.class);
                intent2.putExtra("paymentDetail", map);
                intent2.putExtra("url", this.r);
                startActivity(intent2);
                finish();
                return;
            } catch (JSONException e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (i == 8544) {
            if (extras != null) {
                this.C = ((ResultWrapper) extras.getSerializable("data")).f531c;
                String str = "Response Data TEZ_VPA_FLOW : " + this.C;
            }
            String str2 = this.C;
            if (str2 == null || str2.length() <= 0) {
                Helper.a("Encounter error while processing your request", (Context) this, true);
                return;
            } else {
                if (b(this.C)) {
                    d();
                    this.y.sendEmptyMessage(0);
                    return;
                }
                return;
            }
        }
        if (i != 12541) {
            return;
        }
        if (extras != null) {
            try {
                this.C = ((ResultWrapper) extras.getSerializable("data")).f531c;
                String str3 = "Response Data UPIPayLinkRequest : " + this.C;
            } catch (Exception e4) {
                Log.e(this.x, e4.getMessage());
                Helper.a("Encounter error while processing your request", (Context) this, true);
                return;
            }
        }
        String str4 = this.C;
        if (str4 == null || str4.length() <= 0) {
            Helper.a("Encounter error while processing your request", (Context) this, true);
        } else if (b(this.C)) {
            c(this.C);
        }
    }

    @Override // com.billdesk.sdk.BaseClass, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        Helper.c(this);
        requestWindowFeature(1);
        this.x = UpiActivity.class.getName();
        if (bundle != null) {
            this.C = bundle.getString("dataStr");
            this.w = bundle.getInt("iChecktxnStatus");
            this.D = bundle.getBoolean("drawer");
            this.f469g = bundle.getString("txtVPA");
            this.i = bundle.getInt(FirebaseAnalytics.Param.INDEX);
            this.E = bundle.getString("vpaBankId");
        }
        getWindow().setSoftInputMode(32);
        HandlerThread handlerThread = new HandlerThread("status_check_thread");
        this.z = handlerThread;
        handlerThread.start();
        this.y = new q(this, this.z.getLooper());
        Intent intent = getIntent();
        this.f463a = (HashMap) intent.getSerializableExtra("paymentDetail");
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("config"));
            this.f464b = jSONObject;
            this.f465c = jSONObject.getJSONObject("UPI_Details");
            this.f464b.getString("name");
            this.B = this.f465c.optString("PSP_logo_VPA_Page");
            this.f466d = this.f465c.optString("PSP_Page_Title");
            this.f467e = this.f465c.optString("PSP_Page_UPI_Id_Lable");
            this.f468f = this.f465c.optString("PSP_Page_UPI_Id_Hint");
        } catch (JSONException e2) {
            Helper.a(getResources().getString(R.string.ERR13), (Context) this, false);
            e2.printStackTrace();
        }
        try {
            b();
            if (this.t != null && !this.f469g.equals("")) {
                this.t.setText(this.f469g);
            }
            Spinner spinner = this.u;
            if (spinner == null || (i = this.i) == 0) {
                return;
            }
            spinner.setSelection(i);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.w >= 1) {
            d();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("dataStr", this.C);
        bundle.putString("vpaBankId", this.E);
        bundle.putInt("iChecktxnStatus", this.w);
        bundle.putBoolean("drawer", this.D);
        if (this.t != null) {
            bundle.putString("txtVPA", ((Object) this.t.getText()) + "");
        }
        if (this.u == null || !this.f465c.has("VPA-type")) {
            return;
        }
        bundle.putInt(FirebaseAnalytics.Param.INDEX, this.u.getSelectedItemPosition());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.A;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.A.dismiss();
    }
}
