package com.billdesk.sdk;

import a.a.c.h;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.billdesk.sdk.ErrorFragment;
import com.billdesk.utils.BillDeskSDKException;
import com.billdesk.utils.FragmentStore;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.ResourceConstants;
import com.billdesk.utils.ResultWrapper;
import com.billdesk.utils.SecurePreferences;
import com.billdesk.utils.URLUtilActivity;
import com.clevertap.android.sdk.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public class PaymentOptions extends BaseClass implements ErrorFragment.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, Object> f408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f412f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<String> f414h;
    public Bundle j;
    public FragmentManager k;
    public LinearLayout l;
    public LinearLayout n;
    public SecurePreferences p;
    public Fragment q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f407a = PaymentOptions.class.getName();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f413g = null;
    public Handler i = null;
    public boolean m = true;
    public LinearLayout o = null;
    public boolean r = false;
    public View.OnClickListener s = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x011a A[Catch: JSONException -> 0x01f7, TryCatch #1 {JSONException -> 0x01f7, blocks: (B:9:0x0059, B:11:0x0094, B:13:0x00d7, B:16:0x0108, B:19:0x011e, B:22:0x0132, B:25:0x0147, B:27:0x014c, B:29:0x0157, B:31:0x016c, B:33:0x0189, B:41:0x01e4, B:40:0x01c5, B:24:0x0143, B:18:0x011a, B:35:0x0195, B:37:0x01b2), top: B:87:0x0059, inners: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0143 A[Catch: JSONException -> 0x01f7, TryCatch #1 {JSONException -> 0x01f7, blocks: (B:9:0x0059, B:11:0x0094, B:13:0x00d7, B:16:0x0108, B:19:0x011e, B:22:0x0132, B:25:0x0147, B:27:0x014c, B:29:0x0157, B:31:0x016c, B:33:0x0189, B:41:0x01e4, B:40:0x01c5, B:24:0x0143, B:18:0x011a, B:35:0x0195, B:37:0x01b2), top: B:87:0x0059, inners: #4 }] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r24) {
            /*
                Method dump skipped, instruction units count: 1066
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.billdesk.sdk.PaymentOptions.a.onClick(android.view.View):void");
        }
    }

    public void a(Exception exc, String str) {
        PaymentLibConstants.u.onError(exc);
        this.l.removeAllViews();
        ErrorFragment errorFragment = new ErrorFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("error", exc);
        bundle.putString("msg", str);
        errorFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(this.l.getId(), errorFragment).commit();
    }

    public void b() {
        if (!new SecurePreferences(getApplicationContext()).getString(PaymentLibConstants.f511b + "_BDBrowser", "N").equalsIgnoreCase("Y")) {
            Log.e(this.f407a, "OTP Webview disabled by config");
        } else if (ActivityCompat.checkSelfPermission(this, "android.permission.RECEIVE_SMS") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECEIVE_SMS"}, 123);
        }
    }

    public final void c() {
        this.j = getIntent().getExtras();
        this.f408b = new HashMap<>();
        PaymentLibConstants.f512c = this.j.getString("msg");
        if (f()) {
            this.f411e = this.j.getString("user-email");
            this.f412f = this.j.getString("user-mobile");
            String str = Constants.AES_PREFIX + this.j.getString("msg") + Constants.AES_SUFFIX;
            String str2 = PaymentLibConstants.f512c.split("\\|")[3];
            if (Helper.a(str2).equals("NA")) {
                Helper.a(getResources().getString(R.string.ERR44), (Context) this, true);
                return;
            }
            String str3 = "Amount [" + str2 + Constants.AES_SUFFIX;
            PaymentLibConstants.u = (LibraryPaymentStatusProtocol) this.j.getParcelable("callback");
            String str4 = "EMAIL: [" + this.f411e + "] , MOBILE: [" + this.f412f + Constants.AES_SUFFIX;
            if (Helper.a(this.j.getString("token")).equals("NA")) {
                this.f408b.put("token", "NA");
                PaymentLibConstants.l = false;
            } else {
                this.f408b.put("token", this.j.getString("token"));
            }
            this.f408b.put("msg", PaymentLibConstants.f512c);
            this.f408b.put("user-email", this.f411e);
            this.f408b.put("user-mobile", this.f412f);
            this.f408b.put("amount", str2);
            String str5 = "Billdesk PaymentOptions  Incoming Msg Value[" + this.f408b.get("msg").toString() + "]Icoming Token Value[" + this.f408b.get("token").toString() + "]AMOUNT[" + this.f408b.get("amount").toString() + Constants.AES_SUFFIX;
            PaymentLibConstants.f514e = this.f408b.get("amount").toString();
            String[] strArrSplit = PaymentLibConstants.f512c.split("\\|");
            String str6 = strArrSplit[0];
            PaymentLibConstants.f511b = str6;
            if (Helper.a(str6).equals("NA")) {
                Helper.a(getResources().getString(R.string.ERR44), (Context) this, true);
                return;
            }
            String str7 = strArrSplit[strArrSplit.length - 2];
            PaymentLibConstants.f513d = str7;
            if (Helper.a(str7).equals("NA")) {
                Helper.a(getResources().getString(R.string.ERR44), (Context) this, true);
            } else {
                String str8 = "Billdesk merchantId[" + PaymentLibConstants.f511b + "]expiry[" + Helper.a(getApplicationContext(), PaymentLibConstants.f511b) + Constants.AES_SUFFIX;
                e();
            }
        }
    }

    @Override // com.billdesk.sdk.ErrorFragment.c
    public void cancel() {
        finish();
    }

    public final void d() {
        SecurePreferences securePreferences = new SecurePreferences(getApplicationContext());
        String str = "Value of TXTPAYCATEGORY =" + securePreferences.getBoolean(PaymentLibConstants.f511b + "_txtpaycategory", false);
        if (securePreferences.getBoolean(PaymentLibConstants.f511b + "_txtpaycategory", false) && !Helper.a(this.j.getString("txtpaycategory")).equals("NA")) {
            this.f414h = new ArrayList<>(Arrays.asList(this.j.getString("txtpaycategory").split(Constants.SEPARATOR_COMMA)));
            String str2 = "Limit option size [" + this.f414h.size() + Constants.AES_SUFFIX;
            Iterator<String> it = this.f414h.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split("-");
                if (strArrSplit.length > 1 && strArrSplit[1].equalsIgnoreCase("f")) {
                    String str3 = strArrSplit[0];
                    this.f413g = str3;
                    if ("SI".equalsIgnoreCase(str3) && strArrSplit.length > 2 && "FIXEDCHECKBOX".equalsIgnoreCase(strArrSplit[2])) {
                        PaymentLibConstants.x = true;
                    }
                    String str4 = "value of force_option =" + strArrSplit[0];
                }
            }
        }
        if (g()) {
            return;
        }
        if (!PaymentLibConstants.l) {
            new h(this, this.f413g, this.f414h, this.f408b, this.o, this.l, this.j, this.k).execute(new Void[0]);
            return;
        }
        try {
            String str5 = "Billdesk url quick pay[" + securePreferences.getString(PaymentLibConstants.f511b + "getQuickPayCards", "Not Find") + Constants.AES_SUFFIX;
            HashMap map = new HashMap();
            map.put("reqid", "CS1009");
            map.put("hidRequestId", "PGIME400");
            map.put("msg", URLEncoder.encode(this.f408b.get("token").toString()));
            Intent intent = new Intent(this, (Class<?>) URLUtilActivity.class);
            intent.putExtra("req_type", 105);
            intent.putExtra("url", securePreferences.getString(PaymentLibConstants.f511b + "getQuickPayCards", "Not Find"));
            intent.putExtra("paymentDetail", map);
            intent.putExtra("isShowProgress", false);
            startActivityForResult(intent, 105);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e() {
        if (!Helper.a(getApplicationContext(), PaymentLibConstants.f511b)) {
            d();
            return;
        }
        String str = "getData calling... " + this.r;
        Intent intent = new Intent(this, (Class<?>) URLUtilActivity.class);
        intent.putExtra("req_type", 106);
        String str2 = "https://online.billdesk.com/MercOnline/SDKController?reqid=getSDKPaymentConfig&msg=" + URLEncoder.encode(PaymentLibConstants.f512c) + "&version=2.1.7";
        String str3 = "Payment options url : " + str2;
        intent.putExtra("url", str2);
        intent.putExtra("paymentDetail", new HashMap());
        intent.putExtra("isShowProgress", this.r);
        startActivityForResult(intent, 106);
    }

    public final boolean f() {
        try {
            if (!Helper.a(PaymentLibConstants.f512c).equals("NA") && !PaymentLibConstants.f512c.equals("")) {
                String[] strArrSplit = PaymentLibConstants.f512c.split("\\|");
                String str = "msg length==" + strArrSplit.length;
                if (strArrSplit.length >= 23) {
                    return true;
                }
                Helper.a(getResources().getString(R.string.ERR44), (Context) this, true);
                return false;
            }
            Helper.a(getResources().getString(R.string.ERR44), (Context) this, true);
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean g() {
        boolean z;
        String string;
        String str;
        String str2;
        StringBuilder sbAppend;
        int i = this.p.getInt(PaymentLibConstants.f511b + "optionlen", 0);
        String str3 = "Length of Payment Options[" + i + Constants.AES_SUFFIX;
        if (i > 0) {
            TreeMap treeMap = new TreeMap();
            TreeMap treeMap2 = new TreeMap();
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    str = "";
                    str2 = "id";
                    break;
                }
                String string2 = this.p.getString(PaymentLibConstants.f511b + "id" + i2, "");
                String str4 = "Payment Option ID===" + string2;
                if (!Helper.a(this.f413g).equals("NA") && this.f413g.equalsIgnoreCase(string2)) {
                    str = "";
                    str2 = "id";
                    treeMap.put(Integer.valueOf(this.p.getInt(PaymentLibConstants.f511b + "Index" + i2, 0)), this.p.getString(PaymentLibConstants.f511b + SDKConstants.PARAM_GAME_REQUESTS_OPTIONS + i2, "0"));
                    treeMap2.put(Integer.valueOf(this.p.getInt(PaymentLibConstants.f511b + "Index" + i2, 0)), string2);
                    break;
                }
                ArrayList<String> arrayList = this.f414h;
                if (arrayList == null || arrayList.size() <= 0 || this.f414h.contains(string2)) {
                    String str5 = "Adding [" + string2 + "][" + this.p.getString(PaymentLibConstants.f511b + SDKConstants.PARAM_GAME_REQUESTS_OPTIONS + i2, "NA") + Constants.AES_SUFFIX;
                    treeMap.put(Integer.valueOf(this.p.getInt(PaymentLibConstants.f511b + "Index" + i2, 0)), this.p.getString(PaymentLibConstants.f511b + SDKConstants.PARAM_GAME_REQUESTS_OPTIONS + i2, "0"));
                    treeMap2.put(Integer.valueOf(this.p.getInt(PaymentLibConstants.f511b + "Index" + i2, 0)), string2);
                }
                i2++;
            }
            if (treeMap.size() >= 1 && (Helper.a(this.f413g).equals("NA") || !this.f413g.equalsIgnoreCase(easypay.appinvoke.manager.Constants.EASYPAY_PAYTYPE_NETBANKING) || !this.f408b.get("msg").toString().split("\\|")[4].equalsIgnoreCase("NA"))) {
                Iterator it = treeMap.entrySet().iterator();
                Iterator it2 = treeMap2.entrySet().iterator();
                this.f409c = new String[treeMap.size()];
                this.f410d = new String[treeMap.size()];
                int i3 = 0;
                while (i3 < treeMap.size()) {
                    Iterator it3 = it;
                    String str6 = "BillDesk back form payment options [" + this.p.getString(PaymentLibConstants.f511b + SDKConstants.PARAM_GAME_REQUESTS_OPTIONS + i3, "0") + Constants.AES_SUFFIX;
                    Iterator it4 = it2;
                    String str7 = "BillDesk back form payment options [" + this.p.getInt(PaymentLibConstants.f511b + this.p.getString(PaymentLibConstants.f511b + SDKConstants.PARAM_GAME_REQUESTS_OPTIONS + i3, "0") + "_is_active", 1) + Constants.AES_SUFFIX;
                    Map.Entry entry = (Map.Entry) it3.next();
                    Map.Entry entry2 = (Map.Entry) it4.next();
                    String string3 = entry.getValue().toString();
                    String string4 = entry2.getValue().toString();
                    if (this.p.getInt(PaymentLibConstants.f511b + this.f410d + "_is_active", 1) == 1) {
                        this.f409c[i3] = string3;
                        this.f410d[i3] = string4;
                        sbAppend = new StringBuilder("Setting Button [").append(i3).append("][").append(string3);
                    } else {
                        sbAppend = new StringBuilder("Not adding [").append(i3).append("][").append(string3).append("][").append(this.p.getInt(PaymentLibConstants.f511b + string4 + "_is_active", 1));
                    }
                    sbAppend.append(Constants.AES_SUFFIX).toString();
                    i3++;
                    it = it3;
                    it2 = it4;
                }
                int i4 = 0;
                while (i4 < i) {
                    String str8 = str2;
                    String str9 = str;
                    String string5 = this.p.getString(PaymentLibConstants.f511b + str8 + i4, str9);
                    if (this.p.getInt(PaymentLibConstants.f511b + string5 + "_is_active", 1) == 1 && string5.equalsIgnoreCase(PaymentLibConstants.t[0]) && !this.f408b.get("token").equals("NA")) {
                        PaymentLibConstants.l = true;
                        return false;
                    }
                    i4++;
                    str2 = str8;
                    str = str9;
                }
                return false;
            }
            string = getResources().getString(R.string.ERR17);
            z = true;
        } else {
            z = true;
            string = getResources().getString(R.string.ERR12);
        }
        Helper.a(string, this, z);
        return z;
    }

    public void h() {
        if (this.f408b == null) {
            FragmentStore fragmentStore = (FragmentStore) getSupportFragmentManager().findFragmentByTag("option");
            this.f408b = fragmentStore.f497c;
            this.f411e = fragmentStore.f498d;
            this.f412f = fragmentStore.f499e;
            this.j = fragmentStore.f501g;
            String str = "config changed after[" + this.f408b.toString() + Constants.AES_SUFFIX;
            PaymentLibConstants.f512c = (String) this.f408b.get("msg");
            if (f()) {
                PaymentLibConstants.f514e = this.f408b.get("amount").toString();
                String[] strArrSplit = PaymentLibConstants.f512c.split("\\|");
                PaymentLibConstants.f511b = strArrSplit[0];
                PaymentLibConstants.f513d = strArrSplit[strArrSplit.length - 2];
                g();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            ResultWrapper resultWrapper = (ResultWrapper) intent.getExtras().getSerializable("data");
            String str = resultWrapper.f531c;
            String str2 = "Billdesk PaymentOptions PaymentLib quickpay xml[" + str + "], Response Result [" + resultWrapper.f529a + Constants.AES_SUFFIX;
            String str3 = "onActivityResult: responsecode " + resultWrapper.f530b;
            switch (i2) {
                case 105:
                    String str4 = "Billdesk gotQPList [" + str + Constants.AES_SUFFIX;
                    Helper.a(this.f407a, str, getApplicationContext());
                    new h(this, this.f413g, this.f414h, this.f408b, this.o, this.l, this.j, this.k).execute(new Void[0]);
                    break;
                case 106:
                    ResultWrapper.RESULT result = resultWrapper.f529a;
                    if (result == ResultWrapper.RESULT.SUCCESS) {
                        if (resultWrapper.f530b != 200) {
                            a(new BillDeskSDKException("No data found " + resultWrapper.f530b), PaymentLibConstants.f510a[1]);
                        } else {
                            try {
                                Helper.a(getApplicationContext(), str, PaymentLibConstants.f511b);
                                try {
                                    b();
                                } catch (ClassNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                                d();
                            } catch (Exception e3) {
                                a(e3, PaymentLibConstants.f510a[1]);
                                return;
                            }
                        }
                        break;
                    } else if (result == ResultWrapper.RESULT.CANCEL) {
                        PaymentLibConstants.u.cancelTransaction();
                        Toast.makeText(this, "Cancelled by user", 0).show();
                        finish();
                    } else {
                        try {
                            a(resultWrapper.f532d, PaymentLibConstants.f510a[0]);
                        } catch (Exception e4) {
                            if (str == null) {
                                a(new BillDeskSDKException("Certificate HostName Mismatch "), "Certificate HostName Mismatch");
                            } else {
                                String str5 = PaymentLibConstants.f510a[1];
                            }
                            e4.printStackTrace();
                            return;
                        }
                    }
                    break;
                case 107:
                    String str6 = "Billdesk emiRequest data [" + str + Constants.AES_SUFFIX;
                    Intent intent2 = new Intent(this, (Class<?>) EmiActivity.class);
                    intent2.putExtra("data", str);
                    intent2.putExtra("paymentDetail", this.f408b);
                    startActivity(intent2);
                    break;
            }
        } catch (Exception unused) {
            Helper.a(getResources().getString(R.string.ERR13), (Context) this, true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        PaymentLibConstants.w = false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.k = supportFragmentManager;
        if (!supportFragmentManager.toString().contains(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID)) {
            PaymentLibConstants.v = this.k;
        }
        Fragment fragmentFindFragmentByTag = this.k.findFragmentByTag("option");
        this.q = fragmentFindFragmentByTag;
        if (fragmentFindFragmentByTag != null) {
            String str = "Billdesk PaymentOptions fragment found setting to mgr layout id[" + this.l.getId() + Constants.AES_SUFFIX;
            h();
            fragmentTransactionBeginTransaction.detach(this.q).attach(this.q).commit();
        } else if (!Helper.b(getApplicationContext())) {
            Helper.a(getResources().getString(R.string.ERR11), (Context) this, true);
        } else {
            c();
            PaymentLibConstants.f517h = this;
        }
    }

    @Override // com.billdesk.sdk.BaseClass, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str = "SavedInstance Bundle [" + bundle + Constants.AES_SUFFIX;
        super.onCreate(bundle);
        this.p = new SecurePreferences(this);
        if (bundle != null) {
            this.f414h = bundle.getStringArrayList("limit_option");
        } else {
            PaymentLibConstants.x = false;
            PaymentLibConstants.k = null;
        }
        String str2 = "current orintation is " + getRequestedOrientation() + "";
        Helper.a(getApplicationContext(), "config", getIntent().getIntExtra(Constants.KEY_ORIENTATION, 0));
        Helper.a(getApplicationContext(), CookieSpecs.DEFAULT, getRequestedOrientation());
        requestWindowFeature(1);
        LinearLayout linearLayout = new LinearLayout(this);
        this.l = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.l.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        this.l.setOrientation(1);
        this.l.setId(124578);
        setContentView(this.l);
        this.o = Helper.a((Context) this);
        this.l.addView(Helper.a("", (Activity) this));
        this.l.addView(this.o);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.k = supportFragmentManager;
        if (!supportFragmentManager.toString().contains(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID)) {
            PaymentLibConstants.v = this.k;
        }
        Fragment fragmentFindFragmentByTag = this.k.findFragmentByTag("option");
        this.q = fragmentFindFragmentByTag;
        if (fragmentFindFragmentByTag != null) {
            String str3 = "Billdesk PaymentOptions fragment found setting to mgr layout id[" + this.l.getId() + Constants.AES_SUFFIX;
            h();
            this.k.beginTransaction().replace(this.l.getId(), this.q).commit();
        } else if (!Helper.b(getApplicationContext())) {
            Helper.a(getResources().getString(R.string.ERR11), (Context) this, true);
        } else {
            c();
            PaymentLibConstants.f517h = this;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Handler handler = this.i;
        if (handler != null) {
            handler.getLooper().quit();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            String str = "Value of Grant Result = " + iArr;
            if (i != 123) {
                super.onRequestPermissionsResult(i, strArr, iArr);
            } else {
                int i2 = iArr[0];
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (PaymentLibConstants.f516g) {
            PaymentLibConstants.f516g = false;
        } else {
            LinearLayout linearLayout = this.n;
            if (linearLayout == null || linearLayout.getChildCount() > 1) {
                return;
            } else {
                PaymentLibConstants.f515f = false;
            }
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
            bundle.putStringArrayList("limit_option", this.f414h);
            String str = "Saving instance [" + bundle + Constants.AES_SUFFIX;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.billdesk.sdk.ErrorFragment.c
    public void tryAgain() {
        this.r = true;
        e();
    }
}
