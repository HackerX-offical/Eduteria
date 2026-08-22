package com.appnew.android.Courses.Activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.appnew.android.Utils.Helper;
import com.eduteria.app.app.R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes6.dex */
public class WebFragActivity extends AppCompatActivity {
    private Context context;
    String from = "";
    ImageView imageIV;
    ImageView iv_back;
    private WebView myWebView;
    String title;
    TextView toolbartitleTV;
    String url;
    private FrameLayout webframe;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        this.context = this;
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_web_frag);
        setSupportActionBar((Toolbar) findViewById(R.id.myProgress_toolbar));
        if (getIntent() != null) {
            this.title = getIntent().getStringExtra("title");
            this.url = getIntent().getStringExtra("url");
            this.from = getIntent().getStringExtra("from");
        }
        ImageView imageView = (ImageView) findViewById(R.id.imageIV);
        this.imageIV = imageView;
        imageView.setVisibility(8);
        this.toolbartitleTV = (TextView) findViewById(R.id.toolbartitleTV);
        this.webframe = (FrameLayout) findViewById(R.id.webframe);
        this.myWebView = (WebView) findViewById(R.id.webView);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_back);
        this.iv_back = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.WebFragActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WebFragActivity.this.onBackPressed();
            }
        });
        this.imageIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.WebFragActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WebFragActivity.this.reloadWebView();
            }
        });
        this.myWebView.getSettings().setLoadsImagesAutomatically(true);
        this.myWebView.getSettings().setJavaScriptEnabled(true);
        this.myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.myWebView.clearCache(true);
        this.myWebView.clearHistory();
        this.myWebView.setScrollBarStyle(0);
        this.myWebView.getSettings().setUseWideViewPort(true);
        this.myWebView.getSettings().setLoadWithOverviewMode(true);
        this.myWebView.getSettings().setSupportZoom(true);
        this.myWebView.getSettings().setBuiltInZoomControls(true);
        this.myWebView.getSettings().setDisplayZoomControls(false);
        this.myWebView.setWebViewClient(new MyBrowser());
        this.myWebView.setWebChromeClient(new WebChromeClient() { // from class: com.appnew.android.Courses.Activity.WebFragActivity.3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                WebFragActivity.this.webframe.setVisibility(0);
                if (newProgress == 100) {
                    WebFragActivity.this.webframe.setVisibility(8);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        String str = this.from;
        if (str == null || str.equalsIgnoreCase("")) {
            this.myWebView.getSettings().setDefaultFontSize((int) getResources().getDimension(R.dimen.sp18));
            this.myWebView.loadUrl(this.url);
            setToolBarTitle(this.title);
            return;
        }
        setToolBarTitle(this.title);
        this.myWebView.getSettings().setDefaultFontSize((int) getResources().getDimension(R.dimen.sp25));
        try {
            this.myWebView.loadData(URLEncoder.encode(this.url, "utf-8").replaceAll("\\+", " "), "text/html; charset=UTF-8", null);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.myWebView.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.Courses.Activity.WebFragActivity.4
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url == null) {
                    return false;
                }
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    return false;
                }
                view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                return true;
            }
        });
    }

    private class MyBrowser extends WebViewClient {
        private MyBrowser() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.endsWith(".pdf") || url.endsWith(".PDF")) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(uri, "application/pdf");
                intent.setFlags(67108864);
                try {
                    WebFragActivity.this.context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(WebFragActivity.this.context, WebFragActivity.this.getResources().getString(R.string.no_application_available_to_view_pdf), 0).show();
                }
            } else {
                view.loadUrl(url);
            }
            WebFragActivity.this.webframe.setVisibility(0);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (request.getUrl().toString().endsWith(".pdf") || request.getUrl().toString().endsWith(".PDF")) {
                Uri uri = Uri.parse(request.getUrl().toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(uri, "application/pdf");
                intent.setFlags(67108864);
                try {
                    WebFragActivity.this.context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(WebFragActivity.this.context, WebFragActivity.this.getResources().getString(R.string.no_application_available_to_view_pdf), 0).show();
                }
            } else {
                view.loadUrl(request.getUrl().toString());
            }
            WebFragActivity.this.webframe.setVisibility(0);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }

    public void setToolBarTitle(String title) {
        this.toolbartitleTV.setText(title);
    }

    public void reloadWebView() {
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.reload();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        supportFinishAfterTransition();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.myWebView.canGoBack()) {
            this.myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
