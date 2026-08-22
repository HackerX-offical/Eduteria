package com.billdesk.sdk;

import a.a.a.a;
import a.a.c.i;
import a.a.c.j;
import a.a.c.k;
import a.a.c.l;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.ResourceConstants;
import com.billdesk.utils.SecurePreferences;
import com.billdesk.utils.WebViewStore;
import com.clevertap.android.sdk.Constants;
import com.facebook.internal.AnalyticsEvents;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class PaymentWebView extends FragmentActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f418c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f420e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bundle f423h;
    public SecurePreferences j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f416a = PaymentWebView.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f417b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f419d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f421f = true;
    public String i = "N";

    public final class JavaScriptInterface {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PaymentWebView.this.a();
            }
        }

        public JavaScriptInterface() {
        }

        @JavascriptInterface
        public void gotMsg(String str) {
            PaymentWebView.this.runOnUiThread(new a());
            PaymentWebView paymentWebView = PaymentWebView.this;
            String str2 = paymentWebView.f416a;
            PaymentLibConstants.u.paymentStatus(str, paymentWebView);
        }
    }

    public final String a(int i) {
        switch (i) {
            case 0:
                return "The certificate is not yet valid";
            case 1:
                return "The certificate has expired";
            case 2:
                return "Hostname mismatch";
            case 3:
                return "The certificate authority is not trusted";
            case 4:
                return "The date of the certificate is invalid";
            case 5:
                return "A generic error occurred";
            case 6:
                return "The number of different SSL errors.";
            default:
                return "Certificate error.";
        }
    }

    public final void a() {
        WebView webView = this.f418c;
        if (webView != null) {
            webView.clearCache(true);
            this.f418c.clearHistory();
            this.f418c.getSettings().setAppCacheEnabled(false);
            this.f418c.getSettings().setAppCacheMaxSize(1L);
            this.f418c.getSettings().setCacheMode(2);
            CookieSyncManager.createInstance(this);
            CookieManager.getInstance().removeAllCookie();
        }
    }

    public final void a(SslErrorHandler sslErrorHandler, SslError sslError) {
        System.out.println("SSL error message: The webpage you are trying to access i.e \n( /" + sslError.getUrl() + " )\n has security certificate (SSL) related error. \n\nError Description: " + a(sslError.getPrimaryError()));
        AlertDialog.Builder message = new AlertDialog.Builder(this).setTitle("SSL Error!").setMessage("The webpage you are trying to access has security certificate (SSL) related error. \n\nError Description: " + a(sslError.getPrimaryError()));
        message.setPositiveButton("Dismiss", new l(this, sslErrorHandler));
        message.show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
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
        SecurePreferences securePreferences = new SecurePreferences(getApplicationContext());
        this.j = securePreferences;
        try {
            if (securePreferences.getString(PaymentLibConstants.f511b + "_BDBrowser", "N").equalsIgnoreCase("Y")) {
                Class.forName("a.a.a.a");
                this.f419d = true;
            } else {
                this.f419d = false;
            }
        } catch (ClassNotFoundException unused) {
            Log.e(this.f416a, "Add BillDesk OTP Reader library");
            this.f419d = false;
        }
        this.f422g = (int) (getResources().getDisplayMetrics().density * 10.0f);
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setId(123654789);
        setContentView(linearLayout);
        WebViewStore webViewStore = (WebViewStore) getSupportFragmentManager().findFragmentByTag(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB);
        if (webViewStore != null) {
            try {
                WebView webView = webViewStore.f552a;
                this.f418c = webView;
                this.f420e = webViewStore.f553b;
                ((ViewGroup) webView.getParent()).removeAllViews();
            } catch (Exception unused2) {
            }
        }
        LinearLayout linearLayout2 = new LinearLayout(getApplicationContext());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        linearLayout2.setOrientation(1);
        Bundle extras = getIntent().getExtras();
        this.f423h = extras;
        PaymentLibConstants.m = extras.getString("url");
        PaymentLibConstants.n = (HashMap) this.f423h.getSerializable("paymentDetail");
        linearLayout2.addView(Helper.a(" ", (Activity) this));
        String str = PaymentLibConstants.m;
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        try {
            if (this.f418c == null) {
                this.f418c = this.f419d ? new a(this) : new WebView(this);
                a();
                this.f418c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.f418c.getSettings().setJavaScriptEnabled(true);
                this.f418c.getSettings().setDomStorageEnabled(true);
                this.f418c.getSettings().setSupportMultipleWindows(true);
                this.f418c.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                if (PaymentLibConstants.u != null) {
                    this.f418c.addJavascriptInterface(new JavaScriptInterface(), "AndroidFunction");
                }
                this.f418c.setWebViewClient(new i(this));
                this.f418c.setWebChromeClient(new j(this));
                String str2 = "";
                for (String str3 : PaymentLibConstants.n.keySet()) {
                    String str4 = "key : " + str3;
                    str2 = str2 + str3 + "=" + URLEncoder.encode(PaymentLibConstants.n.get(str3), "UTF-8") + "&";
                }
                String strSubstring = str2.substring(0, str2.length() - 1);
                String str5 = "Billdesk url [" + str + "]final string [" + strSubstring + Constants.AES_SUFFIX;
                this.f418c.postUrl(str, strSubstring.getBytes());
                LinearLayout linearLayout3 = new LinearLayout(this);
                this.f420e = linearLayout3;
                linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.f420e.setGravity(17);
                this.f420e.setBackgroundColor(-1431984731);
                k kVar = new k(this, this);
                kVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                kVar.setOrientation(1);
                kVar.setBackgroundColor(getResources().getColor(R.color.bd_loader_bg));
                int i = this.f422g;
                kVar.setPadding(i, i, i, i);
                ProgressBar progressBar = new ProgressBar(this);
                int iA = Helper.a("loader_img", getApplicationContext());
                int i2 = this.f422g;
                progressBar.setPadding(i2, i2, i2, i2);
                if (iA == 0) {
                    progressBar.getIndeterminateDrawable().setColorFilter(Helper.c("bd_progress_bar", ResourceConstants.f524d, this), PorterDuff.Mode.MULTIPLY);
                } else {
                    progressBar.setIndeterminateDrawable(getResources().getDrawable(iA));
                }
                kVar.setGravity(17);
                kVar.addView(progressBar);
                TextView textView = new TextView(this);
                textView.setText("We're processing your payment request!");
                kVar.addView(textView);
                this.f420e.addView(kVar);
                getSupportFragmentManager().beginTransaction().add(new WebViewStore(this.f418c, this.f420e, this.f419d), AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB).commit();
            }
            relativeLayout.addView(this.f418c);
            relativeLayout.addView(this.f420e);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        linearLayout2.addView(relativeLayout);
        this.f421f = this.j.getBoolean(PaymentLibConstants.f511b + "_cid_unique", true);
        this.i = this.j.getString(PaymentLibConstants.f511b + "_SSLBypass", "N");
        String str6 = "SSLBypass: " + this.i;
        if (this.f421f) {
            BaseClass baseClass = PaymentLibConstants.f517h;
            if (baseClass != null) {
                baseClass.finish();
            }
            BaseClass baseClass2 = PaymentLibConstants.i;
            if (baseClass2 != null) {
                baseClass2.finish();
            }
            BaseClass baseClass3 = PaymentLibConstants.j;
            if (baseClass3 != null) {
                baseClass3.finish();
            }
        }
        linearLayout.addView(linearLayout2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        WebView webView = this.f418c;
        if (webView != null && this.f419d) {
            a aVar = (a) webView;
            aVar.getClass();
            try {
                if (aVar.j && aVar.f112h) {
                    unregisterReceiver(aVar.n);
                    aVar.f112h = false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        WebView webView = this.f418c;
        if (webView != null && this.f419d) {
            ((a) webView).b(this);
        }
        super.onResume();
    }
}
