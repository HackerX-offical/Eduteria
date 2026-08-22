package com.billdesk.sdk;

import a.a.c.m;
import a.a.c.n;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.billdesk.utils.BackgroundContainer;
import com.billdesk.utils.CustomBaseAdapter;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.QuickPaySaveData;
import com.billdesk.utils.ResourceConstants;
import com.billdesk.utils.ResultWrapper;
import com.billdesk.utils.SecurePreferences;
import com.billdesk.utils.URLUtilActivity;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.variables.CTVariableUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class QuickPayView extends BaseClass {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f428c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap<String, Object> f431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Dialog f432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AlertDialog f433h;
    public CustomBaseAdapter i;
    public ListView j;
    public HashMap<String, String> k;
    public EditText l;
    public int n;
    public SecurePreferences o;
    public BackgroundContainer p;
    public int t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f426a = QuickPayView.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f427b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f429d = "false";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f430e = "false";
    public int m = -1;
    public boolean q = false;
    public boolean r = false;
    public HashMap<Long, Integer> s = new HashMap<>();
    public boolean u = true;
    public View.OnClickListener v = new a();
    public AdapterView.OnItemClickListener w = new b();
    public View.OnTouchListener x = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x005f, code lost:
        
            if (r4.f434a.l.getText().length() < 4) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
        
            if (r4.f434a.l.getText().length() < 3) goto L22;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r5) {
            /*
                r4 = this;
                r5 = 0
                com.billdesk.utils.PaymentLibConstants.w = r5
                java.lang.String r0 = ""
                org.json.JSONObject r1 = com.billdesk.utils.PaymentLibConstants.k     // Catch: org.json.JSONException -> L22
                java.lang.String r2 = "quick_pay_list"
                org.json.JSONArray r1 = r1.getJSONArray(r2)     // Catch: org.json.JSONException -> L22
                com.billdesk.sdk.QuickPayView r2 = com.billdesk.sdk.QuickPayView.this     // Catch: org.json.JSONException -> L22
                int r2 = r2.m     // Catch: org.json.JSONException -> L22
                java.lang.Object r1 = r1.get(r2)     // Catch: org.json.JSONException -> L22
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: org.json.JSONException -> L22
                java.lang.String r2 = "cardnetwork"
                java.lang.Object r1 = r1.get(r2)     // Catch: org.json.JSONException -> L22
                java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> L22
                goto L38
            L22:
                r1 = move-exception
                com.billdesk.sdk.QuickPayView r2 = com.billdesk.sdk.QuickPayView.this
                android.content.res.Resources r2 = r2.getResources()
                int r3 = com.billdesk.sdk.R.string.ERR36
                java.lang.String r2 = r2.getString(r3)
                com.billdesk.sdk.QuickPayView r3 = com.billdesk.sdk.QuickPayView.this
                com.billdesk.utils.Helper.a(r2, r3, r5)
                r1.printStackTrace()
                r1 = r0
            L38:
                com.billdesk.sdk.QuickPayView r2 = com.billdesk.sdk.QuickPayView.this
                android.widget.EditText r2 = r2.l
                android.text.Editable r2 = r2.getText()
                java.lang.String r2 = r2.toString()
                boolean r0 = r2.equals(r0)
                java.lang.String r2 = "amex"
                if (r0 != 0) goto L7f
                boolean r0 = r2.equalsIgnoreCase(r1)
                if (r0 == 0) goto L62
                com.billdesk.sdk.QuickPayView r0 = com.billdesk.sdk.QuickPayView.this
                android.widget.EditText r0 = r0.l
                android.text.Editable r0 = r0.getText()
                int r0 = r0.length()
                r1 = 4
                if (r0 >= r1) goto L72
                goto L85
            L62:
                com.billdesk.sdk.QuickPayView r0 = com.billdesk.sdk.QuickPayView.this
                android.widget.EditText r0 = r0.l
                android.text.Editable r0 = r0.getText()
                int r0 = r0.length()
                r1 = 3
                if (r0 >= r1) goto L72
                goto L97
            L72:
                com.billdesk.sdk.QuickPayView r5 = com.billdesk.sdk.QuickPayView.this
                android.app.Dialog r5 = r5.f432g
                r5.dismiss()
                com.billdesk.sdk.QuickPayView r5 = com.billdesk.sdk.QuickPayView.this
                r5.c()
                goto La0
            L7f:
                boolean r0 = r2.equalsIgnoreCase(r1)
                if (r0 == 0) goto L97
            L85:
                com.billdesk.sdk.QuickPayView r0 = com.billdesk.sdk.QuickPayView.this
                android.content.res.Resources r0 = r0.getResources()
                int r1 = com.billdesk.sdk.R.string.ERR40
            L8d:
                java.lang.String r0 = r0.getString(r1)
                com.billdesk.sdk.QuickPayView r1 = com.billdesk.sdk.QuickPayView.this
                com.billdesk.utils.Helper.a(r0, r1, r5)
                goto La0
            L97:
                com.billdesk.sdk.QuickPayView r0 = com.billdesk.sdk.QuickPayView.this
                android.content.res.Resources r0 = r0.getResources()
                int r1 = com.billdesk.sdk.R.string.ERR21
                goto L8d
            La0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.billdesk.sdk.QuickPayView.a.onClick(android.view.View):void");
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            QuickPayView quickPayView = QuickPayView.this;
            quickPayView.m = i;
            quickPayView.b("");
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f437b = -1;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f439a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f440b;

            public a(View view, boolean z) {
                this.f439a = view;
                this.f440b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f439a.setAlpha(1.0f);
                this.f439a.setTranslationX(0.0f);
                if (!this.f440b) {
                    QuickPayView.this.p.a();
                    QuickPayView.this.q = false;
                    QuickPayView.this.j.setEnabled(true);
                    return;
                }
                QuickPayView quickPayView = QuickPayView.this;
                ListView listView = quickPayView.j;
                View view = this.f439a;
                quickPayView.getClass();
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                for (int i = 0; i < listView.getChildCount(); i++) {
                    View childAt = listView.getChildAt(i);
                    if (childAt != view) {
                        quickPayView.s.put(Long.valueOf(quickPayView.i.getItemId(firstVisiblePosition + i)), Integer.valueOf(childAt.getTop()));
                    }
                }
                quickPayView.m = quickPayView.j.getPositionForView(view);
                quickPayView.b();
                ViewTreeObserver viewTreeObserver = listView.getViewTreeObserver();
                viewTreeObserver.addOnPreDrawListener(new n(quickPayView, viewTreeObserver, listView));
            }
        }

        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float width;
            boolean z;
            float f2;
            if (this.f437b < 0) {
                this.f437b = ViewConfiguration.get(QuickPayView.this).getScaledTouchSlop();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                float width2 = 0.0f;
                if (action == 1) {
                    QuickPayView quickPayView = QuickPayView.this;
                    if (quickPayView.q) {
                        float x = (motionEvent.getX() + view.getTranslationX()) - this.f436a;
                        float fAbs = Math.abs(x);
                        if (fAbs > view.getWidth() / 4) {
                            width = fAbs / view.getWidth();
                            width2 = x < 0.0f ? -view.getWidth() : view.getWidth();
                            f2 = 0.0f;
                            z = true;
                        } else {
                            width = 1.0f - (fAbs / view.getWidth());
                            z = false;
                            f2 = 1.0f;
                        }
                        long j = (int) ((1.0f - width) * 250.0f);
                        QuickPayView.this.j.setEnabled(false);
                        if (j < 1) {
                            j = 5;
                        }
                        view.animate().setDuration(j).alpha(f2).translationX(width2).withEndAction(new a(view, z));
                    } else {
                        quickPayView.m = quickPayView.j.getPositionForView(view);
                        QuickPayView quickPayView2 = QuickPayView.this;
                        quickPayView2.i.a(quickPayView2.m);
                        QuickPayView.this.b("");
                    }
                    QuickPayView.this.r = false;
                } else if (action == 2) {
                    float x2 = motionEvent.getX() + view.getTranslationX();
                    float fAbs2 = Math.abs(x2 - this.f436a);
                    QuickPayView quickPayView3 = QuickPayView.this;
                    if (!quickPayView3.q && fAbs2 > this.f437b) {
                        quickPayView3.q = true;
                        QuickPayView.this.j.requestDisallowInterceptTouchEvent(true);
                        BackgroundContainer backgroundContainer = QuickPayView.this.p;
                        int top = view.getTop();
                        int height = view.getHeight();
                        backgroundContainer.setWillNotDraw(false);
                        backgroundContainer.f473c = top;
                        backgroundContainer.f474d = height;
                        backgroundContainer.f471a = true;
                        backgroundContainer.f475e = true;
                    }
                    if (QuickPayView.this.q) {
                        view.setTranslationX(x2 - this.f436a);
                        view.setAlpha(1.0f - (fAbs2 / view.getWidth()));
                    }
                } else {
                    if (action != 3) {
                        return false;
                    }
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    QuickPayView.this.r = false;
                }
            } else {
                QuickPayView quickPayView4 = QuickPayView.this;
                if (quickPayView4.r) {
                    return false;
                }
                quickPayView4.r = true;
                this.f436a = motionEvent.getX();
            }
            return true;
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            QuickPayView.this.finish();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            CustomBaseAdapter customBaseAdapter = QuickPayView.this.i;
            customBaseAdapter.getClass();
            try {
                customBaseAdapter.f481b = PaymentLibConstants.k.getJSONArray("quick_pay_list");
                customBaseAdapter.notifyDataSetChanged();
            } catch (JSONException unused) {
            }
            dialogInterface.dismiss();
            QuickPayView.this.f427b = null;
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            Intent intent = new Intent(QuickPayView.this, (Class<?>) URLUtilActivity.class);
            intent.putExtra("req_type", 106);
            intent.putExtra("url", QuickPayView.this.o.getString(PaymentLibConstants.f511b + "deleteQPCard", "Not FOUND"));
            QuickPayView.this.o.getString(PaymentLibConstants.f511b + "deleteQPCard", "NOT FOUND");
            intent.putExtra("paymentDetail", QuickPayView.this.k);
            QuickPayView quickPayView = QuickPayView.this;
            quickPayView.f427b = null;
            quickPayView.startActivityForResult(intent, 106);
        }
    }

    public class g extends Dialog {
        public g(Context context) {
            super(context);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            super.onBackPressed();
            QuickPayView.this.i.a(-1);
        }
    }

    public final void b(String str) {
        String string;
        try {
            string = ((JSONObject) PaymentLibConstants.k.getJSONArray("quick_pay_list").get(this.m)).get("cardnetwork").toString();
            try {
                if ("maestro".equalsIgnoreCase(string)) {
                    c();
                    return;
                }
            } catch (JSONException e2) {
                e = e2;
                Helper.a(getResources().getString(R.string.ERR36), (Context) this, false);
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
            string = "";
        }
        this.f432g = new g(this);
        LinearLayout linearLayout = new LinearLayout(this);
        int i = this.n * 2;
        linearLayout.setLayoutParams(Helper.a(this, 17, -1, 0, new int[]{i, 0, i, 0}));
        int i2 = this.n * 3;
        linearLayout.setPadding(i2, i2, i2, i2);
        linearLayout.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        linearLayout.setOrientation(1);
        this.f432g.requestWindowFeature(1);
        this.f432g.getWindow().setSoftInputMode(5);
        TextView textView = new TextView(this);
        Helper.a(textView, false, (Activity) this);
        textView.setText(string.equalsIgnoreCase("amex") ? "Enter your Batch Code to verify" : "Enter your CVV number to verify");
        int i3 = this.n;
        textView.setPadding(i3, i3, i3, i3);
        textView.setTextSize(2, 16.0f);
        EditText editText = new EditText(this);
        this.l = editText;
        editText.setInputType(18);
        this.l.setImeOptions(268435456);
        if (string.equalsIgnoreCase("amex")) {
            this.l.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        } else {
            this.l.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        }
        this.l.requestFocus();
        if (!str.equals("")) {
            this.l.setText(str);
            EditText editText2 = this.l;
            editText2.setSelection(editText2.getText().length());
        }
        Button buttonA = Helper.a((Activity) this, "SUBMIT");
        buttonA.setOnClickListener(this.v);
        linearLayout.addView(textView);
        linearLayout.addView(this.l);
        linearLayout.addView(buttonA);
        this.f432g.setContentView(linearLayout);
        this.f432g.getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.8d), -2);
        this.f432g.show();
    }

    public boolean b() {
        String str = "Deleting card - Index [" + this.m + Constants.AES_SUFFIX;
        try {
            JSONArray jSONArray = PaymentLibConstants.k.getJSONArray("quick_pay_list");
            this.k = new HashMap<>();
            JSONObject jSONObject = (JSONObject) jSONArray.get(this.m);
            this.k.put("msg", this.f428c);
            this.k.put("reqid", "CS1008");
            this.k.put("txtBankID", "NA");
            this.k.put("cardType", jSONObject.getString("accounttype"));
            this.k.put("paymentid", jSONObject.getString("token"));
            this.f427b = jSONObject.getString("cardend");
        } catch (Exception e2) {
            Helper.a(getResources().getString(R.string.ERR36), (Context) this, false);
            Log.e(this.f426a, "BillDesk error while deleting card [" + e2.getMessage() + Constants.AES_SUFFIX);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure want to delete card ****" + this.f427b + " ?");
        builder.setNegativeButton("No", new e());
        builder.setPositiveButton("Yes", new f());
        builder.create().show();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01a1 A[Catch: JSONException -> 0x03cf, TryCatch #0 {JSONException -> 0x03cf, blocks: (B:6:0x0034, B:8:0x0060, B:11:0x006c, B:14:0x0079, B:16:0x0085, B:20:0x00f0, B:27:0x013e, B:29:0x0144, B:31:0x0154, B:34:0x016d, B:36:0x0179, B:39:0x018a, B:41:0x0195, B:43:0x01a1, B:46:0x01c4, B:48:0x01d3, B:72:0x0313, B:74:0x035f, B:75:0x0364, B:77:0x0374, B:79:0x037c, B:47:0x01cc, B:40:0x0190, B:32:0x0167, B:23:0x0133, B:49:0x0251, B:51:0x0261, B:53:0x028f, B:55:0x02ae, B:58:0x02bf, B:60:0x02ca, B:62:0x02d4, B:65:0x02f1, B:66:0x02f9, B:71:0x030e, B:59:0x02c5, B:67:0x02fd, B:68:0x0301, B:70:0x030c, B:69:0x0305), top: B:84:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01cc A[Catch: JSONException -> 0x03cf, TryCatch #0 {JSONException -> 0x03cf, blocks: (B:6:0x0034, B:8:0x0060, B:11:0x006c, B:14:0x0079, B:16:0x0085, B:20:0x00f0, B:27:0x013e, B:29:0x0144, B:31:0x0154, B:34:0x016d, B:36:0x0179, B:39:0x018a, B:41:0x0195, B:43:0x01a1, B:46:0x01c4, B:48:0x01d3, B:72:0x0313, B:74:0x035f, B:75:0x0364, B:77:0x0374, B:79:0x037c, B:47:0x01cc, B:40:0x0190, B:32:0x0167, B:23:0x0133, B:49:0x0251, B:51:0x0261, B:53:0x028f, B:55:0x02ae, B:58:0x02bf, B:60:0x02ca, B:62:0x02d4, B:65:0x02f1, B:66:0x02f9, B:71:0x030e, B:59:0x02c5, B:67:0x02fd, B:68:0x0301, B:70:0x030c, B:69:0x0305), top: B:84:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02d4 A[Catch: JSONException -> 0x03cf, TryCatch #0 {JSONException -> 0x03cf, blocks: (B:6:0x0034, B:8:0x0060, B:11:0x006c, B:14:0x0079, B:16:0x0085, B:20:0x00f0, B:27:0x013e, B:29:0x0144, B:31:0x0154, B:34:0x016d, B:36:0x0179, B:39:0x018a, B:41:0x0195, B:43:0x01a1, B:46:0x01c4, B:48:0x01d3, B:72:0x0313, B:74:0x035f, B:75:0x0364, B:77:0x0374, B:79:0x037c, B:47:0x01cc, B:40:0x0190, B:32:0x0167, B:23:0x0133, B:49:0x0251, B:51:0x0261, B:53:0x028f, B:55:0x02ae, B:58:0x02bf, B:60:0x02ca, B:62:0x02d4, B:65:0x02f1, B:66:0x02f9, B:71:0x030e, B:59:0x02c5, B:67:0x02fd, B:68:0x0301, B:70:0x030c, B:69:0x0305), top: B:84:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instruction units count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.billdesk.sdk.QuickPayView.c():void");
    }

    public final void c(String str) {
        this.k.put("cvv2", str);
    }

    public final void d() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(getResources().getString(R.string.ERR38)).setNeutralButton("OK", new d()).create();
        this.f433h = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.f433h.show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = ((ResultWrapper) intent.getSerializableExtra("data")).f531c;
        String str2 = "BillDesk response[" + str + Constants.AES_SUFFIX;
        if (i2 != 106) {
            try {
                Helper.a(this.f426a, str, getApplicationContext());
                JSONArray jSONArray = PaymentLibConstants.k.getJSONArray("quick_pay_list");
                View.OnTouchListener onTouchListener = this.x;
                CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(this, jSONArray);
                customBaseAdapter.f483d = onTouchListener;
                this.i = customBaseAdapter;
                this.j.setAdapter((ListAdapter) customBaseAdapter);
                if (PaymentLibConstants.k.getJSONArray("quick_pay_list").length() < 1) {
                    finish();
                    return;
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.getString("Status").toString().equals("Y")) {
                String str3 = "Card not removed from list [" + jSONObject.getString("ErrorDescription").toString() + Constants.AES_SUFFIX;
                Helper.a("Card not removed from list ", (Context) this, false);
                return;
            }
            HashMap map = new HashMap();
            map.put("reqid", "CS1009");
            map.put("hidRequestId", "PGIME400");
            map.put("msg", URLEncoder.encode(this.f428c));
            Intent intent2 = new Intent(this, (Class<?>) URLUtilActivity.class);
            intent2.putExtra("req_type", 105);
            intent2.putExtra("url", this.o.getString(PaymentLibConstants.f511b + "getQuickPayCards", ""));
            intent2.putExtra("paymentDetail", map);
            startActivityForResult(intent2, 105);
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (!PaymentLibConstants.f515f) {
            PaymentLibConstants.f516g = false;
        } else {
            PaymentLibConstants.f516g = true;
            PaymentLibConstants.f515f = false;
        }
    }

    @Override // com.billdesk.sdk.BaseClass, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getRequestedOrientation() <= -1) {
                int iB = Helper.b(getApplicationContext(), "config");
                if (iB == 2) {
                    setRequestedOrientation(0);
                } else if (iB == 1) {
                    setRequestedOrientation(1);
                } else {
                    setRequestedOrientation(4);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("data");
        try {
            if (fragmentFindFragmentByTag != null) {
                QuickPaySaveData quickPaySaveData = (QuickPaySaveData) fragmentFindFragmentByTag;
                if (PaymentLibConstants.k == null) {
                    PaymentLibConstants.k = new JSONObject(quickPaySaveData.f518a);
                }
                PaymentLibConstants.f514e = quickPaySaveData.f519b;
                PaymentLibConstants.f511b = quickPaySaveData.f520c;
            } else {
                getSupportFragmentManager().beginTransaction().add(new QuickPaySaveData(PaymentLibConstants.k.toString(), PaymentLibConstants.f514e, PaymentLibConstants.f511b), "data").commit();
            }
        } catch (Exception unused) {
        }
        HashMap<String, Object> map = (HashMap) getIntent().getExtras().get("paymentDetail");
        this.f431f = map;
        if (map == null || map.size() == 0) {
            finish();
            return;
        }
        this.f428c = this.f431f.get("token").toString();
        String str = "TOKEN: [" + this.f428c + Constants.AES_SUFFIX;
        requestWindowFeature(1);
        this.t = Build.VERSION.SDK_INT;
        this.n = (int) (getResources().getDisplayMetrics().density * 10.0f);
        this.o = new SecurePreferences(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setWeightSum(10.0f);
        linearLayout.setLayoutParams(layoutParams);
        int i = getResources().getConfiguration().orientation == 2 ? 38 : 12;
        LinearLayout linearLayoutA = Helper.a("", (Activity) this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i);
        layoutParams2.weight = 1.0f;
        linearLayoutA.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayoutA);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView textView = new TextView(this);
        textView.setText("Payment Amount: ₹ " + PaymentLibConstants.f514e);
        Helper.a(textView, false, (Activity) this);
        textView.setBackgroundColor(0);
        textView.setGravity(17);
        textView.setTextSize(2, 20.0f);
        textView.setLayoutParams(Helper.a(this, 17, i, -1, new int[]{0, 0, 0, 0}));
        linearLayout2.addView(textView);
        linearLayout.addView(linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 7.0f));
        ListView listView = new ListView(this);
        this.j = listView;
        listView.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        this.j.setCacheColorHint(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        this.j.setDividerHeight(3);
        try {
            if (PaymentLibConstants.k == null || PaymentLibConstants.k.getJSONArray("quick_pay_list").length() <= 0) {
                Log.e(this.f426a, "payViaOtherModes==" + PaymentLibConstants.f515f + ",isShowCardListDilog==" + PaymentLibConstants.y);
                if (PaymentLibConstants.f515f) {
                    PaymentLibConstants.f515f = false;
                    PaymentLibConstants.f516g = false;
                    PaymentLibConstants.w = false;
                    if (PaymentLibConstants.y) {
                        d();
                        PaymentLibConstants.y = false;
                    } else {
                        finish();
                    }
                } else {
                    PaymentLibConstants.f515f = false;
                    PaymentLibConstants.f516g = false;
                    PaymentLibConstants.w = false;
                    PaymentLibConstants.y = false;
                    d();
                }
            } else {
                if (this.t > 15) {
                    BackgroundContainer backgroundContainer = new BackgroundContainer(this);
                    this.p = backgroundContainer;
                    int i2 = this.n;
                    backgroundContainer.setPadding(i2, i2, i2, i2);
                    JSONArray jSONArray = PaymentLibConstants.k.getJSONArray("quick_pay_list");
                    View.OnTouchListener onTouchListener = this.x;
                    CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(this, jSONArray);
                    customBaseAdapter.f483d = onTouchListener;
                    this.i = customBaseAdapter;
                } else {
                    this.i = new CustomBaseAdapter(this, PaymentLibConstants.k.getJSONArray("quick_pay_list"));
                    this.j.setOnItemClickListener(this.w);
                    this.j.setOnTouchListener(new m(this, getApplicationContext()));
                }
                this.j.setAdapter((ListAdapter) this.i);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        linearLayout3.addView(this.j);
        linearLayout.addView(linearLayout3);
        linearLayout.addView(a(true));
        setContentView(linearLayout);
        PaymentLibConstants.i = this;
        try {
            if (PaymentLibConstants.k != null) {
                if (PaymentLibConstants.k.getJSONArray("quick_pay_list").length() != 0) {
                    if (bundle != null) {
                        this.u = bundle.getBoolean("showToast");
                    }
                    if (this.u) {
                        Toast.makeText(this, "Tap on card to enter CVV / Batch code of the saved card.", 1).show();
                        this.u = false;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String string = bundle.getString(CTVariableUtils.NUMBER);
        this.m = bundle.getInt("selected");
        if (string != null) {
            b(string);
        }
        String string2 = bundle.getString("CardNumber");
        this.f427b = string2;
        if (string2 != null) {
            b();
        }
        PaymentLibConstants.i = this;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("showToast", this.u);
        bundle.putInt("selected", this.m);
        String str = this.f427b;
        if (str != null) {
            bundle.putString("CardNumber", str);
        }
        Dialog dialog = this.f432g;
        if (dialog != null && dialog.isShowing()) {
            bundle.putString(CTVariableUtils.NUMBER, this.l.getText().toString());
            this.f432g.dismiss();
        }
        AlertDialog alertDialog = this.f433h;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f433h.dismiss();
        finish();
    }
}
