package a.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.appnew.android.Utils.Const;
import com.billdesk.sdk.CreditCardView;
import com.billdesk.sdk.QuickPayView;
import com.billdesk.sdk.R;
import com.billdesk.sdk.UpiActivity;
import com.billdesk.utils.FragmentStore;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.SecurePreferences;
import com.billdesk.utils.URLUtilAsync;
import com.clevertap.android.sdk.Constants;
import datamodels.PWEStaticDataModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends AsyncTask<Void, Intent, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<String> f152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<String, Object> f154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f155h;
    public Bundle i;
    public FragmentManager j;
    public boolean k = true;
    public boolean l = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f157b;

        public a(String str, boolean z) {
            this.f156a = str;
            this.f157b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Helper.a(this.f156a, h.this.f148a, this.f157b);
        }
    }

    public h(Context context, String str, ArrayList<String> arrayList, HashMap<String, Object> map, LinearLayout linearLayout, LinearLayout linearLayout2, Bundle bundle, FragmentManager fragmentManager) {
        this.f153f = null;
        this.f148a = context;
        this.f153f = h.class.getName();
        this.f151d = str;
        this.f152e = arrayList;
        this.f154g = map;
        this.f155h = linearLayout2;
        this.i = bundle;
        this.f149b = bundle.getString("user-email");
        this.f150c = bundle.getString("user-mobile");
        this.j = fragmentManager;
    }

    public final void a() {
        try {
            JSONArray jSONArray = new JSONArray(new SecurePreferences(this.f148a).getString(PaymentLibConstants.f511b + Const.IMAGES, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
            int length = jSONArray.length();
            PaymentLibConstants.o = new HashMap<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String str = "BillDesk json Images[" + jSONArray.getString(i) + "][" + jSONObject.getString("id") + "] Image url is [" + jSONObject.getString("image_url") + Constants.AES_SUFFIX;
                PaymentLibConstants.o.put(jSONObject.getString("id"), jSONObject.getString("image_url"));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, boolean z) {
        new Handler(this.f148a.getMainLooper()).post(new a(str, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(String str) {
        String string;
        JSONObject jSONObject;
        char c2;
        String str2;
        SecurePreferences securePreferences = new SecurePreferences(this.f148a.getApplicationContext());
        char c3 = 0;
        int i = securePreferences.getInt(PaymentLibConstants.f511b + "optionlen", 0);
        String str3 = "Length of Payment Options[" + i + Constants.AES_SUFFIX;
        String str4 = "Force Option [" + str + Constants.AES_SUFFIX;
        String string2 = "";
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                string = securePreferences.getString(PaymentLibConstants.f511b + "id" + i2, "");
                if (!string.equalsIgnoreCase(str)) {
                }
            }
            string = "";
        } else {
            string = "";
        }
        try {
            jSONObject = new JSONObject(securePreferences.getString(PaymentLibConstants.f511b + "Other" + string, "{}"));
            try {
                if (jSONObject.has("redirect")) {
                    string2 = jSONObject.getString("redirect");
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
        }
        if ("QP".equalsIgnoreCase(str)) {
            Intent intent = new Intent(this.f148a, (Class<?>) QuickPayView.class);
            intent.putExtra("paymentDetail", this.f154g);
            publishProgress(intent);
            return true;
        }
        if (!easypay.appinvoke.manager.Constants.EASYPAY_PAYTYPE_CREDIT_CARD.equalsIgnoreCase(str)) {
            try {
                if (easypay.appinvoke.manager.Constants.EASYPAY_PAYTYPE_DEBIT_CARD.equalsIgnoreCase(str) || easypay.appinvoke.manager.Constants.EASYPAY_PAYTYPE_NETBANKING.equalsIgnoreCase(str)) {
                    return b(securePreferences.getString(PaymentLibConstants.f511b + string + "BankList", "0"));
                }
                if (!string2.equalsIgnoreCase("UPI_APP") || (!PWEStaticDataModel.PAYOPT_UPI_DISPLAY_NAME.equalsIgnoreCase(str) && !"Tez".equalsIgnoreCase(str) && !"GPAY".equalsIgnoreCase(str))) {
                    return b(securePreferences.getString(PaymentLibConstants.f511b + "Other" + string, "{}"));
                }
                try {
                    Intent intent2 = new Intent(this.f148a, (Class<?>) UpiActivity.class);
                    intent2.putExtra("paymentDetail", Helper.a(this.f154g, jSONObject));
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("clickedOn", string);
                    publishProgress(intent2);
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return false;
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
                return false;
            }
        }
        try {
            Intent intent3 = new Intent(this.f148a, (Class<?>) CreditCardView.class);
            JSONObject jSONObject2 = new JSONObject(securePreferences.getString(PaymentLibConstants.f511b + "CreditCardType", "{}"));
            String string3 = jSONObject2.getString("makePaymentCreditUrl");
            JSONArray jSONArray = new JSONArray(jSONObject2.getString("card-type"));
            String str5 = "BillDesk back payOptions.length[" + jSONArray.length() + Constants.AES_SUFFIX;
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                c2 = c3;
                try {
                    String string4 = jSONObject3.getString("name");
                    String string5 = jSONObject3.getString("bank_id");
                    JSONArray jSONArray2 = jSONArray;
                    String string6 = jSONObject3.getString("item-code");
                    int i4 = i3;
                    if (string4.equalsIgnoreCase("American Express")) {
                        intent3.putExtra("hasamex", "1");
                        intent3.putExtra("A_bankID", string5);
                        str2 = "A_itemCode";
                    } else if (string4.equalsIgnoreCase("MasterCard")) {
                        intent3.putExtra("hasmaster", "1");
                        intent3.putExtra("M_bankID", string5);
                        str2 = "M_itemCode";
                    } else if (string4.equalsIgnoreCase("Visa")) {
                        intent3.putExtra("hasvisa", "1");
                        intent3.putExtra("V_bankID", string5);
                        str2 = "V_itemCode";
                    } else if (string4.contains("Diners")) {
                        intent3.putExtra("hasdiners", "1");
                        intent3.putExtra("D_bankID", string5);
                        str2 = "D_itemCode";
                    } else if (string4.equalsIgnoreCase("RuPay")) {
                        intent3.putExtra("hasRuPay16", "1");
                        intent3.putExtra("R_bankID", string5);
                        str2 = "R_itemCode";
                    } else {
                        String str6 = "BillDesk Card Type is [" + string4 + Constants.AES_SUFFIX;
                        i3 = i4 + 1;
                        jSONArray = jSONArray2;
                        c3 = c2;
                    }
                    intent3.putExtra(str2, string6);
                    String str62 = "BillDesk Card Type is [" + string4 + Constants.AES_SUFFIX;
                    i3 = i4 + 1;
                    jSONArray = jSONArray2;
                    c3 = c2;
                } catch (JSONException e6) {
                    e = e6;
                    e.printStackTrace();
                    Log.e(this.f153f, "String [" + securePreferences.getString(PaymentLibConstants.f511b + "CreditCardType", "{}") + Constants.AES_SUFFIX);
                    boolean z = c2;
                    a(this.f148a.getResources().getString(R.string.ERR13), z);
                    return z;
                }
            }
            c2 = c3;
            intent3.putExtra("override_bank_id", jSONObject2.getString("override_bank_id"));
            intent3.putExtra("override_item_code", jSONObject2.getString("override_item_code"));
            intent3.putExtra("url", string3);
            intent3.putExtra("paymentDetail", this.f154g);
            Intent[] intentArr = new Intent[1];
            intentArr[c2] = intent3;
            publishProgress(intentArr);
            return true;
        } catch (JSONException e7) {
            e = e7;
            c2 = c3;
        }
    }

    public final void b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        int i = Build.VERSION.SDK_INT;
        String str3 = new String();
        String str4 = new String();
        try {
            str3 = ((TelephonyManager) this.f148a.getSystemService("phone")).getDeviceId();
        } catch (Exception e2) {
            Log.e(this.f153f, "OTHER Oops Exception [" + e2.getMessage() + Constants.AES_SUFFIX);
        }
        try {
            str4 = this.f148a.getPackageManager().getPackageInfo(this.f148a.getPackageName(), 0).versionName;
        } catch (Exception e3) {
            Log.e(this.f153f, "OTHER Oops Exception [" + e3.getMessage() + Constants.AES_SUFFIX);
        }
        String str5 = Helper.a(this.f150c) + "|" + Helper.a(str) + Constants.SEPARATOR_COMMA + Helper.a(str2) + "|2.1.7|" + Helper.a(str4) + "|" + i + "|" + Helper.a(str3) + "|" + Helper.a(this.f149b) + "|0.0,0.0|" + this.f148a.getResources().getString(R.string.app_name) + "|" + Helper.a(this.i.getString("txtpaycategory")) + "|NA|NA|NA|NA|NA|NA|NA|NA";
        String str6 = "OTHER MY FINAL STRING [" + str5 + Constants.AES_SUFFIX;
        new URLUtilAsync(this.f148a, (HashMap<String, String>) new HashMap(), "https://online.billdesk.com/MercOnline/SDKController?reqid=saveAnalyticsDetails&msg=" + URLEncoder.encode(str5) + "&pg_msg=" + URLEncoder.encode(PaymentLibConstants.f512c));
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.String r33) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 793
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.c.h.b(java.lang.String):boolean");
    }

    public final void c() {
        Resources resources;
        int i;
        FragmentTransaction fragmentTransactionBeginTransaction;
        LinearLayout linearLayout;
        HashMap<String, Object> map = this.f154g;
        if (map == null || map.size() == 0 || Helper.a(this.f154g.get("msg").toString()).equals("NA")) {
            resources = this.f148a.getResources();
            i = R.string.ERR13;
        } else {
            if (!this.k || !this.l) {
                try {
                    b();
                } catch (Exception e2) {
                    String str = "GPS exception [" + e2.getMessage() + Constants.AES_SUFFIX;
                }
                String str2 = "Billdesk PaymentOptions msg[" + this.f154g.get("msg").toString() + "] token[" + this.f154g.get("token") + "][" + PaymentLibConstants.l + Constants.AES_SUFFIX;
                a();
                FragmentStore fragmentStore = new FragmentStore(this.f154g, this.f150c, this.f149b, this.i);
                String str3 = "Billdesk PaymentOptions begain transation[" + this.j + "]layout id[" + this.f155h.getId() + Constants.AES_SUFFIX;
                try {
                    if (this.j.toString().contains(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID)) {
                        String str4 = "Billdesk PaymentOptions begain transation[" + PaymentLibConstants.v + "]layout id[" + this.f155h.getId() + Constants.AES_SUFFIX;
                        fragmentTransactionBeginTransaction = this.j.beginTransaction();
                        linearLayout = this.f155h;
                    } else {
                        fragmentTransactionBeginTransaction = this.j.beginTransaction();
                        linearLayout = this.f155h;
                    }
                    fragmentTransactionBeginTransaction.replace(linearLayout.getId(), fragmentStore, "option").commitAllowingStateLoss();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            resources = this.f148a.getResources();
            i = R.string.ERR17;
        }
        a(resources.getString(i), true);
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void[] voidArr) {
        int size;
        this.f148a.getClass().getName();
        boolean z = false;
        if (!PaymentLibConstants.w) {
            SecurePreferences securePreferences = new SecurePreferences(this.f148a.getApplicationContext());
            String string = securePreferences.getString(PaymentLibConstants.f511b + "_txtDefaultCategory", "NA");
            String str = this.f151d;
            if (str != null) {
                a(str);
            } else if (!Helper.a(string).equals("NA")) {
                ArrayList<String> arrayList = this.f152e;
                if (arrayList == null || arrayList.size() <= 0) {
                    size = securePreferences.getInt(PaymentLibConstants.f511b + "optionlen", 0);
                } else if (this.f152e.contains(string)) {
                    size = this.f152e.size();
                } else if (this.f152e.size() == 1 && this.f152e.get(0).equalsIgnoreCase("QP") && PaymentLibConstants.k == null) {
                    a(this.f148a.getResources().getString(R.string.ERR38), true);
                    size = 0;
                }
                String str2 = "Length of Payment Options[" + size + Constants.AES_SUFFIX;
                if (size > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        ArrayList<String> arrayList2 = this.f152e;
                        String string2 = (arrayList2 == null || arrayList2.size() <= 0 || !this.f152e.contains(string)) ? securePreferences.getString(PaymentLibConstants.f511b + "id" + i, "") : this.f152e.get(i);
                        if (string.equals(string2)) {
                            PaymentLibConstants.f515f = true;
                            if (a(string2)) {
                                publishProgress(null, new Intent());
                                a();
                                if (string2.equalsIgnoreCase("QP") && size == 1) {
                                    PaymentLibConstants.y = true;
                                } else {
                                    PaymentLibConstants.y = false;
                                    z = true;
                                }
                            }
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        Boolean bool2 = bool;
        if (!bool2.booleanValue()) {
            c();
        }
        super.onPostExecute(bool2);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Intent[] intentArr) {
        Intent[] intentArr2 = intentArr;
        Intent intent = intentArr2[0];
        if (intent != null) {
            intent.setFlags(268435456);
            this.f148a.startActivity(intentArr2[0]);
        } else if (intentArr2.length > 1) {
            new Handler().postDelayed(new g(this), 2000L);
        } else {
            c();
        }
        super.onProgressUpdate(intentArr2);
    }
}
