package com.appnew.android.Payment.easy_pay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Utils.Helper;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.paytm.pgsdk.PaytmWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: EasyPayCheckout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0015J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0006\u0010\"\u001a\u00020\u001dJ\u0006\u0010#\u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0017J\b\u0010&\u001a\u00020\u001dH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/appnew/android/Payment/easy_pay/EasyPayCheckout;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "webview", "Landroid/webkit/WebView;", "getWebview", "()Landroid/webkit/WebView;", "setWebview", "(Landroid/webkit/WebView;)V", "progress", "Landroid/app/ProgressDialog;", "getProgress", "()Landroid/app/ProgressDialog;", "setProgress", "(Landroid/app/ProgressDialog;)V", "easyPayUrl", "", "getEasyPayUrl", "()Ljava/lang/String;", "setEasyPayUrl", "(Ljava/lang/String;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configureWebView", "webView", "show", "hide", "show_alert", "msg", "onBackPressed", "MyWebViewClient", "MyJavaScriptInterface", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EasyPayCheckout extends AppCompatActivity {
    public static final int $stable = 8;
    private String easyPayUrl = "";
    private Context mContext;
    private ProgressDialog progress;
    private WebView webview;

    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(Context context) {
        this.mContext = context;
    }

    public final WebView getWebview() {
        return this.webview;
    }

    public final void setWebview(WebView webView) {
        this.webview = webView;
    }

    public final ProgressDialog getProgress() {
        return this.progress;
    }

    public final void setProgress(ProgressDialog progressDialog) {
        this.progress = progressDialog;
    }

    public final String getEasyPayUrl() {
        return this.easyPayUrl;
    }

    public final void setEasyPayUrl(String str) {
        this.easyPayUrl = str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fone_pay_checkout);
        Helper.enableScreenShot(this);
        EasyPayCheckout easyPayCheckout = this;
        this.mContext = easyPayCheckout;
        ProgressDialog progressDialog = new ProgressDialog(easyPayCheckout);
        this.progress = progressDialog;
        progressDialog.setMessage("Loading...");
        ProgressDialog progressDialog2 = this.progress;
        if (progressDialog2 != null) {
            progressDialog2.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog3 = this.progress;
        if (progressDialog3 != null) {
            progressDialog3.setCancelable(true);
        }
        View viewFindViewById = findViewById(R.id.webview);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.webkit.WebView");
        WebView webView = (WebView) viewFindViewById;
        this.webview = webView;
        if (webView != null) {
            webView.addJavascriptInterface(new MyJavaScriptInterface(), PaytmWebView.HTML_OUT);
        }
        WebView webView2 = this.webview;
        if (webView2 != null) {
            webView2.setWebChromeClient(new WebChromeClient());
        }
        WebView webView3 = this.webview;
        if (webView3 != null) {
            webView3.setWebViewClient(new MyWebViewClient());
        }
        WebView webView4 = this.webview;
        Intrinsics.checkNotNull(webView4);
        configureWebView(webView4);
        show();
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("amount", 0);
            this.easyPayUrl = intent.getStringExtra("easyPayUrl");
            if (Integer.parseInt(String.valueOf(intExtra)) > 0) {
                WebView webView5 = this.webview;
                Intrinsics.checkNotNull(webView5);
                String str = this.easyPayUrl;
                Intrinsics.checkNotNull(str);
                webView5.loadUrl(str);
                return;
            }
            Toast.makeText(easyPayCheckout, "Amount must be greater than zero", 1).show();
        }
    }

    /* JADX INFO: compiled from: EasyPayCheckout.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/appnew/android/Payment/easy_pay/EasyPayCheckout$MyWebViewClient;", "Landroid/webkit/WebViewClient;", "<init>", "(Lcom/appnew/android/Payment/easy_pay/EasyPayCheckout;)V", "onPageFinished", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "url", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MyWebViewClient extends WebViewClient {
        public MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            WebView webview;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(EasyPayCheckout.this.getWebview(), url);
            ProgressDialog progress = EasyPayCheckout.this.getProgress();
            if (progress != null && progress.isShowing()) {
                EasyPayCheckout.this.hide();
            }
            if (StringsKt.equals(url, EasyPayCheckout.this.getEasyPayUrl(), true) || (webview = EasyPayCheckout.this.getWebview()) == null) {
                return;
            }
            webview.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
        }
    }

    private final void configureWebView(WebView webView) {
        WebSettings settings;
        WebSettings settings2;
        WebSettings settings3;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setClickable(true);
        webView.setLongClickable(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setAllowContentAccess(true);
        WebView webView2 = this.webview;
        if (webView2 != null && (settings3 = webView2.getSettings()) != null) {
            settings3.setDefaultTextEncodingName("utf-8");
        }
        WebView webView3 = this.webview;
        if (webView3 != null && (settings2 = webView3.getSettings()) != null) {
            settings2.setSupportMultipleWindows(true);
        }
        WebView webView4 = this.webview;
        if (webView4 != null && (settings = webView4.getSettings()) != null) {
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
        WebView.setWebContentsDebuggingEnabled(false);
        webView.getSettings().setMixedContentMode(2);
    }

    /* JADX INFO: compiled from: EasyPayCheckout.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/Payment/easy_pay/EasyPayCheckout$MyJavaScriptInterface;", "", "<init>", "(Lcom/appnew/android/Payment/easy_pay/EasyPayCheckout;)V", "processHTML", "", "html", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MyJavaScriptInterface {
        public MyJavaScriptInterface() {
        }

        @JavascriptInterface
        public final void processHTML(String html) {
            Intrinsics.checkNotNullParameter(html, "html");
            Document document = Jsoup.parse(html);
            Element elementFirst = document.select("tr:contains(Status)").first();
            Element elementFirst2 = document.select("tr:contains(TXN ID)").first();
            if (elementFirst != null) {
                Element elementLast = elementFirst.select("td").last();
                Intrinsics.checkNotNull(elementLast);
                String strText = elementLast.text();
                if (StringsKt.equals(strText, "true", true)) {
                    Intrinsics.checkNotNull(elementFirst2);
                    Element elementLast2 = elementFirst2.select("td").last();
                    Intrinsics.checkNotNull(elementLast2);
                    String strText2 = elementLast2.text();
                    Intrinsics.checkNotNullExpressionValue(strText2, "text(...)");
                    Intent intent = EasyPayCheckout.this.getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                    intent.putExtra("status", strText);
                    intent.putExtra("post_txn_id", strText2);
                    EasyPayCheckout.this.setResult(-1, intent);
                    EasyPayCheckout.this.finish();
                    return;
                }
                Intent intent2 = EasyPayCheckout.this.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
                intent2.putExtra("status", strText);
                intent2.putExtra("post_txn_id", "");
                EasyPayCheckout.this.setResult(0, intent2);
                EasyPayCheckout.this.finish();
            }
        }
    }

    public final void show() {
        ProgressDialog progressDialog;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        if (((Activity) context).isFinishing() || (progressDialog = this.progress) == null) {
            return;
        }
        Intrinsics.checkNotNull(progressDialog);
        if (progressDialog.isShowing()) {
            return;
        }
        ProgressDialog progressDialog2 = this.progress;
        Intrinsics.checkNotNull(progressDialog2);
        progressDialog2.show();
    }

    public final void hide() {
        ProgressDialog progressDialog;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        if (((Activity) context).isFinishing() || (progressDialog = this.progress) == null) {
            return;
        }
        Intrinsics.checkNotNull(progressDialog);
        if (progressDialog.isShowing()) {
            ProgressDialog progressDialog2 = this.progress;
            Intrinsics.checkNotNull(progressDialog2);
            progressDialog2.dismiss();
        }
    }

    public final void show_alert(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        alertDialogCreate.setTitle("Error!!!");
        String str = msg;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "\n", false, 2, (Object) null)) {
            msg = new Regex("\\\n").replace(str, "");
        }
        alertDialogCreate.setMessage(msg);
        alertDialogCreate.setButton(-1, "OK", new DialogInterface.OnClickListener() { // from class: com.appnew.android.Payment.easy_pay.EasyPayCheckout$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.finish();
            }
        });
        alertDialogCreate.show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        intent.putExtra("status", false);
        intent.putExtra("post_txn_id", "");
        setResult(0, intent);
        finish();
    }
}
