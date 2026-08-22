package com.billdesk.sdk;

import a.a.c.c;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.ResourceConstants;
import com.clevertap.android.sdk.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BankList extends BaseClass {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<a.a.b.a> f357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<String> f358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, Object> f359e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355a = BankList.class.getName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f360f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f361g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AdapterView.OnItemClickListener f362h = new a();

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x031b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0097  */
        @Override // android.widget.AdapterView.OnItemClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onItemClick(android.widget.AdapterView<?> r17, android.view.View r18, int r19, long r20) {
            /*
                Method dump skipped, instruction units count: 860
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.billdesk.sdk.BankList.a.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (PaymentLibConstants.f515f) {
            PaymentLibConstants.f516g = true;
            PaymentLibConstants.f515f = false;
        } else {
            PaymentLibConstants.f516g = false;
        }
        PaymentLibConstants.w = false;
    }

    @Override // com.billdesk.sdk.BaseClass, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Helper.c(this);
        Bundle extras = getIntent().getExtras();
        this.f356b = extras.getString("msg");
        this.f359e = (HashMap) extras.getSerializable("paymentDetail");
        String string = extras.getString("bankList");
        String str = "Billdesk jsonString[" + string + Constants.AES_SUFFIX;
        if (string.length() <= 0) {
            Helper.a(getResources().getString(R.string.ERR17), (Context) this, true);
            return;
        }
        requestWindowFeature(1);
        try {
            this.f357c = new ArrayList<>();
            this.f358d = new ArrayList<>();
            JSONObject jSONObject = new JSONObject(string);
            JSONArray jSONArray = new JSONArray(jSONObject.getString(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS));
            String str2 = "BillDesk back payOptions.length[" + jSONArray.length() + Constants.AES_SUFFIX;
            int length = jSONArray.length();
            this.f360f = jSONObject.getString("override_item_code");
            this.f361g = jSONObject.getString("override_bank_id");
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                a.a.b.a aVar = new a.a.b.a();
                aVar.f129a = jSONObject2.getString("bank-id");
                jSONObject2.getString("payment-option");
                try {
                    aVar.f130b = jSONObject2.getString("card-type");
                    jSONObject2.getString("top-index");
                } catch (Exception e2) {
                    Log.w(this.f355a, "card type and top index not found [" + e2.getMessage() + Constants.AES_SUFFIX);
                }
                aVar.f131c = jSONObject2.getString("redirect");
                aVar.f132d = jSONObject2.getString("redirect-url");
                aVar.f133e = jSONObject2.getString("hid-requestid");
                aVar.f134f = jSONObject2.getString("hid-operation");
                aVar.f135g = jSONObject2.getString("item-code");
                this.f357c.add(aVar);
                this.f358d.add(jSONObject2.getString("payment-option"));
            }
        } catch (JSONException unused) {
            Log.e(this.f355a, getResources().getString(R.string.ERR39));
        } catch (Exception e3) {
            e3.printStackTrace();
            Helper.a(getResources().getString(R.string.ERR18), (Context) this, true);
        }
        getResources().getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setWeightSum(10.0f);
        linearLayout.setLayoutParams(layoutParams);
        int i2 = getResources().getConfiguration().orientation == 2 ? 38 : 12;
        LinearLayout linearLayoutA = Helper.a("", (Activity) this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i2);
        layoutParams2.weight = 1.0f;
        linearLayoutA.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayoutA);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView textView = new TextView(this);
        textView.setText("Select your Option");
        Helper.a(textView, false, (Activity) this);
        textView.setBackgroundColor(0);
        textView.setGravity(17);
        textView.setTextSize(2, 20.0f);
        textView.setLayoutParams(Helper.a(this, 17, i2, -1, new int[]{0, 0, 0, 0}));
        linearLayout2.addView(textView);
        linearLayout.addView(linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 7.0f));
        ListView listView = new ListView(this);
        c cVar = new c(this, this, android.R.layout.simple_list_item_1, this.f358d);
        listView.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        listView.setCacheColorHint(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        listView.setAdapter((ListAdapter) cVar);
        listView.setOnItemClickListener(this.f362h);
        linearLayout3.addView(listView);
        linearLayout.addView(linearLayout3);
        linearLayout.addView(a(true));
        setContentView(linearLayout);
    }
}
