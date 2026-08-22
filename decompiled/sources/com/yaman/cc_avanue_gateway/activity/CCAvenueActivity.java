package com.yaman.cc_avanue_gateway.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.pgsdk.PaytmWebView;
import com.yaman.cc_avanue_gateway.R;
import com.yaman.cc_avanue_gateway.model.orderDetails;
import com.yaman.cc_avanue_gateway.utils.MyWebViewClient;
import com.yaman.cc_avanue_gateway.utils.UpiListener;

/* JADX INFO: loaded from: classes9.dex */
public class CCAvenueActivity extends AppCompatActivity implements UpiListener {
    Context mContext;
    orderDetails order;
    ProgressDialog progress;
    WebView webview;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ccavenue);
        this.mContext = this;
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.progress = progressDialog;
        progressDialog.setMessage("Loading...");
        this.progress.setCanceledOnTouchOutside(false);
        this.progress.setCancelable(false);
        WebView webView = (WebView) findViewById(R.id.webview);
        this.webview = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.getSettings().setSupportMultipleWindows(true);
        this.webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.webview.addJavascriptInterface(new MyJavaScriptInterface(), PaytmWebView.HTML_OUT);
        this.webview.setWebChromeClient(new WebChromeClient());
        show();
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("amount", 0);
            String stringExtra = intent.getStringExtra("order_id");
            String stringExtra2 = intent.getStringExtra("enc_val");
            intent.getStringExtra("name");
            String stringExtra3 = intent.getStringExtra("access_code");
            String stringExtra4 = intent.getStringExtra("redirect_url");
            String stringExtra5 = intent.getStringExtra("cancel_url");
            String stringExtra6 = intent.getStringExtra("post_url");
            orderDetails orderdetails = new orderDetails();
            this.order = orderdetails;
            orderdetails.setOrder_id(stringExtra);
            this.order.setAccess_code(stringExtra3);
            this.order.setCancel_url(stringExtra5);
            this.order.setRedirect_url(stringExtra4);
            this.order.setEnc_val(stringExtra2);
            if (Integer.parseInt(String.valueOf(intExtra)) > 0) {
                this.webview.postUrl(stringExtra6, ("encRequest=" + this.order.getEnc_val() + "&access_code=" + this.order.getAccess_code()).getBytes());
            } else {
                Toast.makeText(this, "Enter a valid Amount greater then 1 Rs. (" + String.valueOf(intExtra) + ")", 1).show();
            }
        }
        this.webview.setWebViewClient(new MyWebViewClient(this, this, this.progress, this.webview, this.order));
    }

    @Override // com.yaman.cc_avanue_gateway.utils.UpiListener
    public void openApp(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            startActivity(intent);
        } catch (Exception e2) {
            Log.e("Payment Failed Exception", e2.getMessage());
        }
    }

    @Override // com.yaman.cc_avanue_gateway.utils.UpiListener
    public void openPlayStore(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str)));
        }
    }

    class MyJavaScriptInterface {
        MyJavaScriptInterface() {
        }

        @JavascriptInterface
        public void processHTML(String str) {
            if (str.indexOf("Failure") != -1) {
                CCAvenueActivity.this.setResult(0, CCAvenueActivity.this.getIntent());
                CCAvenueActivity.this.finish();
                Toast.makeText(CCAvenueActivity.this, "Transaction Declined!", 0).show();
                return;
            }
            if (str.indexOf("Success") != -1) {
                Intent intent = CCAvenueActivity.this.getIntent();
                intent.putExtra("result", str);
                CCAvenueActivity.this.setResult(-1, intent);
                CCAvenueActivity.this.finish();
                Toast.makeText(CCAvenueActivity.this, "Transaction Successful!", 0).show();
                return;
            }
            if (str.indexOf("Aborted") != -1) {
                CCAvenueActivity.this.setResult(0, CCAvenueActivity.this.getIntent());
                CCAvenueActivity.this.finish();
                Toast.makeText(CCAvenueActivity.this, "Transaction Cancelled!", 0).show();
            }
        }
    }

    public void show() {
        ProgressDialog progressDialog;
        if (((Activity) this.mContext).isFinishing() || (progressDialog = this.progress) == null || progressDialog.isShowing()) {
            return;
        }
        this.progress.show();
    }

    public void hide() {
        ProgressDialog progressDialog;
        if (((Activity) this.mContext).isFinishing() || (progressDialog = this.progress) == null || !progressDialog.isShowing()) {
            return;
        }
        this.progress.dismiss();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
