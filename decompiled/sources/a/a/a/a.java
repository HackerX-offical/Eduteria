package a.a.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.appnew.android.Utils.Service.SmsBroadcastReceiver;
import com.billdesk.library.OtpDialogActivity;
import com.clevertap.android.sdk.Constants;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f112h;
    public boolean i;
    public boolean j;
    public String k;
    public String l;
    public BroadcastReceiver m;
    public BroadcastReceiver n;

    /* JADX INFO: renamed from: a.a.a.a$a, reason: collision with other inner class name */
    public class C0000a extends BroadcastReceiver {
        public C0000a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = a.this.f105a;
            if (intent != null && intent.getAction().equals("com.billdesk.library.DialogRequest") && intent.hasExtra(SaslNonza.Response.ELEMENT) && intent.getBooleanExtra(SaslNonza.Response.ELEMENT, false)) {
                a aVar = a.this;
                String str2 = aVar.f105a;
                String str3 = aVar.f107c;
                aVar.loadUrl("javascript:var frame = window.frames;var bdfill = false;var bdregex = " + aVar.l + ";innerObj = document.body;var text = innerObj.querySelectorAll(\"input[type='password']\");if (text.length > 0) {for (txtIdx = 0; txtIdx < text.length; txtIdx++) {if(text[txtIdx].offsetParent!==null && text[txtIdx].style.display!=='none' && !text[txtIdx].readOnly){text[txtIdx].autocomplete = 'bakk';text[txtIdx].value= \"" + str3 + "\";text[txtIdx].setAttribute(\"value\",\"" + str3 + "\");bdfill = true;}}} if(!bdfill){text = innerObj.querySelectorAll(\"input[type='text']\");for (txtIdx = 0; txtIdx < text.length; txtIdx++) {if(text[txtIdx].offsetParent!==null && text[txtIdx].style.display!=='none' && !text[txtIdx].readOnly){text[txtIdx].autocomplete = 'bakk';text[txtIdx].value=\"" + str3 + "\";text[txtIdx].setAttribute(\"value\",\"" + str3 + "\");bdfill = true;}}}if(!bdfill){text=innerObj.querySelectorAll(\"input[type='number']\");for(txtIdx=0;txtIdx<text.length;txtIdx++){if(text[txtIdx].offsetParent!==null && text[txtIdx].style.display!=='none' && !text[txtIdx].readOnly){text[txtIdx].autocomplete = 'bakk';text[txtIdx].value=\"" + str3 + "\";text[txtIdx].setAttribute(\"value\",\"" + str3 + "\");bdfill = true;}}}var ckb = innerObj.querySelectorAll(\"input[type='checkbox']\");for (txtIdx = 0; txtIdx < ckb.length; txtIdx++) {if(ckb[txtIdx].offsetParent!==null && ckb[txtIdx].style.display!=='none')ckb[txtIdx].checked = true;}var submit = innerObj.querySelectorAll(\"input[type='submit']\");if (bdfill) {bdfill = false;if (submit.length > 0) {for (subIdx = 0; subIdx < submit.length; subIdx++) {if(bdregex.test(submit[subIdx].value) && !bdfill && submit[subIdx].offsetParent!==null && submit[subIdx].style.display!=='none') {submit[subIdx].click(); bdfill = true;}}}submit = innerObj.querySelectorAll(\"input[type='button']\");if (submit.length > 0 && !bdfill) {for (subIdx = 0; subIdx < submit.length; subIdx++) {if(bdregex.test(submit[subIdx].value) && !bdfill && submit[subIdx].offsetParent!==null && submit[subIdx].style.display!=='none') {submit[subIdx].click(); bdfill = true;}}}submit = innerObj.querySelectorAll(\"button\");if (submit.length > 0 && !bdfill) {for (subIdx = 0; subIdx < submit.length; subIdx++) {if (bdregex.test(submit[subIdx].innerHTML) && !bdfill && submit[subIdx].offsetParent!==null && submit[subIdx].style.display!=='none') {submit[subIdx].click(); bdfill = true;}}}submit = innerObj.querySelectorAll(\"a\");if (submit.length > 0 && !bdfill) {for (subIdx = 0; subIdx < submit.length; subIdx++) {if (bdregex.test(submit[subIdx].innerHTML) && !bdfill && submit[subIdx].offsetParent!==null && submit[subIdx].style.display!=='none') {submit[subIdx].click(); bdfill = true;}}}submit = innerObj.querySelectorAll(\"input[type='image']\");if (submit.length > 0) {submit[0].click();}}");
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String str = a.this.f105a;
            String str2 = "Billdesk receiver activated bundle[" + extras + Constants.AES_SUFFIX;
            if (extras != null) {
                try {
                    Object[] objArr = (Object[]) extras.get(SmsBroadcastReceiver.SMS_BUNDLE);
                    String str3 = a.this.f105a;
                    String str4 = "Got PDUS Obj [" + objArr + Constants.AES_SUFFIX;
                    for (Object obj : objArr) {
                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                        String str5 = a.this.f105a;
                        String str6 = "Got message from : " + smsMessageCreateFromPdu.getDisplayOriginatingAddress() + "\nMessage: [" + smsMessageCreateFromPdu.getDisplayMessageBody() + Constants.AES_SUFFIX;
                        String strB = a.b(a.this, smsMessageCreateFromPdu.getDisplayMessageBody());
                        if (strB != null && !strB.trim().isEmpty()) {
                            a.this.f111g = false;
                            a.this.f108d = smsMessageCreateFromPdu.getDisplayOriginatingAddress();
                            a.this.f107c = strB;
                            if (a.this.f110f) {
                                String str7 = a.this.f105a;
                                a.this.b();
                            } else {
                                String str8 = a.this.f105a;
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e(a.this.f105a, "Exception smsReceiver" + e2);
                }
            }
        }
    }

    public class c extends a.a.a.b.d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f115e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ byte[] f116f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, HashMap map, String str, String str2, byte[] bArr) {
            super(context, map, str);
            this.f115e = str2;
            this.f116f = bArr;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            JSONObject jSONObject;
            String str2;
            Context context;
            Toast toastMakeText;
            String str3 = str;
            try {
                jSONObject = new JSONObject(str3);
                str2 = "bd_browser_key is invalid";
            } catch (Exception e2) {
                Log.e(a.this.f105a, "bd_browser_key could not be validated ", e2);
                Toast.makeText(a.this.f106b, "bd_browser_key could not be validated ", 1).show();
            }
            if (str3 == null) {
                Log.e(a.this.f105a, "bd_browser_key is invalid");
                context = a.this.f106b;
            } else if (jSONObject.has("otp_config")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("otp_config");
                if (jSONObject2.has("otp_pattern") && jSONObject2.has("button_label_pattern")) {
                    a.this.k = jSONObject2.getString("otp_pattern");
                    String str4 = a.this.f105a;
                    String str5 = "otp_pattern==" + a.this.k;
                    a.this.l = jSONObject2.getString("button_label_pattern");
                    a.this.j = true;
                    a aVar = a.this;
                    aVar.b(aVar.f106b);
                    if (jSONObject2.has("otp_string") && (!jSONObject2.getString("otp_string").equals("") || !jSONObject2.getString("otp_string").equals(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID))) {
                        a.this.f109e = jSONObject2.getString("otp_string");
                        String str6 = a.this.f105a;
                        String str7 = "otp_string==" + a.this.f109e;
                    }
                    a.a(a.this, this.f115e, this.f116f);
                }
                Log.e(a.this.f105a, "bd_browser_key is invalid");
                context = a.this.f106b;
            } else {
                if (jSONObject.has("errorMessage")) {
                    String string = jSONObject.getString("errorMessage");
                    if (string != null && !string.trim().isEmpty()) {
                        str2 = string;
                    }
                    Log.e(a.this.f105a, "Error in getting otp config. Message : " + jSONObject.getString("errorMessage"));
                    toastMakeText = Toast.makeText(a.this.f106b, str2, 1);
                    toastMakeText.show();
                    a.a(a.this, this.f115e, this.f116f);
                }
                Log.e(a.this.f105a, "bd_browser_key is invalid");
                context = a.this.f106b;
            }
            toastMakeText = Toast.makeText(context, "bd_browser_key is invalid", 1);
            toastMakeText.show();
            a.a(a.this, this.f115e, this.f116f);
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f118a;

        /* JADX INFO: renamed from: a.a.a.a$d$a, reason: collision with other inner class name */
        public class RunnableC0001a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f120a;

            public RunnableC0001a(String str) {
                this.f120a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.a(a.this, this.f120a);
            }
        }

        public d(Activity activity) {
            this.f118a = activity;
        }

        @JavascriptInterface
        public void createSnackBar(String str) {
            String str2 = a.this.f105a;
            String str3 = "JSInterface reached createSnackBar[" + a.this.f107c + Constants.AES_SUFFIX;
            a.this.f111g = true;
            this.f118a.runOnUiThread(new RunnableC0001a(str));
        }
    }

    public a(Context context) {
        super(context);
        this.f105a = a.class.getName();
        this.f109e = "otp|one time password";
        this.f110f = false;
        this.f111g = false;
        this.f112h = false;
        this.i = false;
        this.j = false;
        this.k = "";
        this.l = "";
        this.m = new C0000a();
        this.n = new b();
        a(context);
    }

    public static void a(a aVar, String str, byte[] bArr) {
        super.postUrl(str, bArr);
    }

    public static String b(a aVar, String str) {
        aVar.getClass();
        String str2 = "msgBody is ==" + str;
        String strGroup = null;
        if (str != null && !str.trim().isEmpty()) {
            String str3 = "otp|one time password==" + aVar.f109e;
            String str4 = "(" + aVar.f109e + ")";
            if (Pattern.compile(str4, 2).matcher(str).find()) {
                String str5 = "while loop running  = " + str4;
                Pattern patternCompile = Pattern.compile(aVar.k);
                String str6 = "otpPattern from config  = " + aVar.k;
                Matcher matcher = patternCompile.matcher(str);
                String str7 = "before while loop running  = " + aVar.k;
                if (matcher.find()) {
                    String str8 = "while loop running  = " + aVar.k;
                    strGroup = matcher.group();
                }
                String str9 = "otp in extractOTP = " + strGroup;
            }
        }
        return strGroup;
    }

    public final void a() {
        LocalBroadcastManager.getInstance(this.f106b).sendBroadcast(new Intent("com.billdesk.library.CloseDialog"));
    }

    public final void b() {
        String str = "Your otp is [" + this.f107c + Constants.AES_SUFFIX;
        String str2 = this.f107c;
        if (str2 == null || str2.trim().isEmpty()) {
            return;
        }
        loadUrl("javascript:var bdfill=false;var bdregex=" + this.l + ";innerObj=document.body;var text=innerObj.querySelectorAll(\"input[type='password']\");if(text.length>0){for(txtIdx=0;txtIdx<text.length;txtIdx++){if(text[txtIdx].offsetParent!==null && text[txtIdx].style.display!=='none' && !text[txtIdx].readOnly)\tbdfill=true;}}if(!bdfill){text=innerObj.querySelectorAll(\"input[type='text']\");for(txtIdx=0;txtIdx<text.length;txtIdx++){if(text[txtIdx].offsetParent!==null && text[txtIdx].style.display!=='none' && !text[txtIdx].readOnly)bdfill=true;}}if(!bdfill){text=innerObj.querySelectorAll(\"input[type='number']\");for(txtIdx=0;txtIdx<text.length;txtIdx++){if(text[txtIdx].offsetParent!==null && text[txtIdx].style.display!=='none' && !text[txtIdx].readOnly)bdfill=true;}}var bdclick=false;if(bdfill){var submit=innerObj.querySelectorAll(\"input[type='submit']\");if(submit.length>0){for(subIdx=0;subIdx<submit.length;subIdx++){if(bdregex.test(submit[subIdx].value) && submit[subIdx].offsetParent!==null && submit[subIdx].style.display!=='none'){bdclick=true;}}}if(!bdclick){submit=innerObj.querySelectorAll(\"input[type='button']\");if(submit.length>0){for(subIdx=0;subIdx<submit.length;subIdx++){if(bdregex.test(submit[subIdx].value) && submit[subIdx].offsetParent!==null && submit[subIdx].style.display!=='none'){bdclick=true;}}}\t}if(!bdclick){submit=innerObj.querySelectorAll(\"button\");if(submit.length>0){for(subIdx=0;subIdx<submit.length;subIdx++){if(bdregex.test(submit[subIdx].innerHTML) && submit[subIdx].offsetParent!==null && submit[subIdx].style.display!=='none'){bdclick=true;}}}}if(!bdclick){submit = innerObj.querySelectorAll(\"a\");if (submit.length > 0) {for (subIdx = 0; subIdx < submit.length; subIdx++) {if (bdregex.test(submit[subIdx].innerHTML) && submit[subIdx].offsetParent!==null && submit[subIdx].style.display!=='none') {bdclick=true;}}} }if(!bdclick){submit = innerObj.querySelectorAll(\"input[type='image']\");if (submit.length > 0) {bdclick=true;}}}if(bdclick){window.BDInterface.createSnackBar(\"APPROVE\");}else{window.BDInterface.createSnackBar(\"COPY\");}");
    }

    public void b(Context context) {
        try {
            if (!this.j || this.f112h) {
                return;
            }
            context.registerReceiver(this.n, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
            this.f112h = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.webkit.WebView
    public void clearHistory() {
        super.clearHistory();
        a();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            LocalBroadcastManager.getInstance(this.f106b).registerReceiver(this.m, new IntentFilter("com.billdesk.library.DialogRequest"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            LocalBroadcastManager.getInstance(this.f106b).unregisterReceiver(this.m);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        a aVar;
        String str2;
        byte[] bArr2;
        HashMap map;
        String str3 = "Post url called=" + str;
        if (this.i) {
            super.postUrl(str, bArr);
            return;
        }
        this.i = true;
        String packageName = this.f106b.getPackageName();
        int identifier = this.f106b.getResources().getIdentifier("bd_browser_key", "string", packageName);
        if (identifier == 0) {
            Log.e(this.f105a, "bd_browser_key not defined");
            Toast.makeText(this.f106b, "bd_browser_key not defined", 1).show();
            super.postUrl(str, bArr);
            return;
        }
        try {
            map = new HashMap();
            map.put("reqid", "getBilldeskBrowserConfig");
            map.put("packageId", packageName);
            map.put("udId", this.f106b.getResources().getString(identifier));
            aVar = this;
            str2 = str;
            bArr2 = bArr;
        } catch (Exception e2) {
            e = e2;
            aVar = this;
            str2 = str;
            bArr2 = bArr;
        }
        try {
            aVar.new c(this.f106b, map, "https://online.billdesk.com/MercOnline/SDKController", str2, bArr2).execute(null);
        } catch (Exception e3) {
            e = e3;
            Log.e(aVar.f105a, "bd_browser_key could not be validated ", e);
            Toast.makeText(aVar.f106b, "bd_browser_key could not be validated ", 1).show();
            super.postUrl(str2, bArr2);
        }
    }

    public void setIsPageLoaded(boolean z) {
        if (!this.f111g && z) {
            b();
        }
        this.f110f = z;
    }

    public static void a(a aVar, String str) {
        aVar.getClass();
        String str2 = "showing otp dialog now with dialogType " + str;
        Intent intent = new Intent(aVar.f106b, (Class<?>) OtpDialogActivity.class);
        intent.putExtra("OTP", aVar.f107c);
        intent.putExtra("sender", aVar.f108d);
        intent.putExtra("type", str);
        aVar.f106b.startActivity(intent);
    }

    public final boolean a(Context context) {
        this.f107c = "";
        this.f108d = "";
        WebSettings settings = getSettings();
        this.f106b = context;
        settings.setJavaScriptEnabled(true);
        this.i = false;
        addJavascriptInterface(new d((Activity) getContext()), "BDInterface");
        try {
            String str = "Manufacturer: " + Build.MANUFACTURER;
            Cursor cursorQuery = this.f106b.getContentResolver().query(Uri.parse("content://sms/inbox"), new String[]{"body"}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                cursorQuery.getString(cursorQuery.getColumnIndex("body"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return true;
    }
}
