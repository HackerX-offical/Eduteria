package com.appnew.android.Webview;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Progress;
import com.appnew.android.table.UserHistroyTable;
import com.eduteria.app.app.R;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class PdfHtmlAcivity extends AppCompatActivity {
    private static Progress progress;
    private ImageView image_back;
    TextView toolbarTitleTV;
    String video_id;
    private WebView webView;
    String file_type = "";
    String course_id = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.webview_html_activity);
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            WebView webView = (WebView) findViewById(R.id.webresourcewebview);
            this.webView = webView;
            webView.setHapticFeedbackEnabled(false);
            this.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.Webview.PdfHtmlAcivity.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View v) {
                    return true;
                }
            });
            this.webView.setLongClickable(false);
            this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            View viewFindViewById = findViewById(R.id.root);
            Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            if (Build.VERSION.SDK_INT == 36) {
                EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
            }
            this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Webview.PdfHtmlAcivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$0();
                }
            }));
            this.file_type = getIntent().getStringExtra("file_type") == null ? "" : getIntent().getStringExtra("file_type");
            this.toolbarTitleTV.setText(getIntent().getStringExtra("type"));
            this.video_id = getIntent().getStringExtra(Const.VIDEO_ID);
            this.course_id = getIntent().getStringExtra("course_id");
            String str = this.video_id;
            this.video_id = (str == null || str.equalsIgnoreCase("")) ? getIntent().getStringExtra("type") : getIntent().getStringExtra(Const.VIDEO_ID);
            progress = new Progress(this);
            startChatBot(getIntent().getStringExtra("url"));
        } catch (Exception e2) {
            if (progress.isShowing()) {
                progress.dismiss();
            }
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    private void startChatBot(String url) {
        progress.show();
        configureWebView(this.webView, url);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    private void configureWebView(final WebView webView, final String url) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setClickable(true);
        webView.setLongClickable(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebChromeClient(new ChatBotChromeClient());
        WebView.setWebContentsDebuggingEnabled(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setDefaultFontSize((int) getResources().getDimension(R.dimen.sp12));
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Webview.PdfHtmlAcivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$configureWebView$3(url, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureWebView$3(String str, final WebView webView) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    stringBuffer.append(line);
                } else {
                    bufferedReader.close();
                    final String string = stringBuffer.toString();
                    runOnUiThread(new Runnable() { // from class: com.appnew.android.Webview.PdfHtmlAcivity$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            webView.loadDataWithBaseURL(null, string, "text/html; charset=UTF-8", "UTF-8", null);
                        }
                    });
                    try {
                        UserHistroyTable userHistroyTable = new UserHistroyTable();
                        userHistroyTable.setVideo_id(this.video_id);
                        userHistroyTable.setPdf_name(this.toolbarTitleTV.getText().toString().trim());
                        userHistroyTable.setType("PDF");
                        userHistroyTable.setPdf_url(str);
                        userHistroyTable.setUser_id(MakeMyExam.userId);
                        userHistroyTable.setCourse_id(this.course_id);
                        userHistroyTable.setCurrent_time("" + MakeMyExam.getTime_server());
                        UtkashRoom.getAppDatabase(this).getuserhistorydao().addUser(userHistroyTable);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
        } catch (Exception e3) {
            if (e3 instanceof FileNotFoundException) {
                e3.printStackTrace();
                runOnUiThread(new Runnable() { // from class: com.appnew.android.Webview.PdfHtmlAcivity$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        PdfHtmlAcivity.lambda$configureWebView$2(webView);
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$configureWebView$2(WebView webView) {
        webView.stopLoading();
        Progress progress2 = progress;
        if (progress2 != null && progress2.isShowing()) {
            progress.dismiss();
        }
        webView.loadUrl("about:blank");
    }

    static class ChatBotChromeClient extends WebChromeClient {
        ChatBotChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress == 100 && PdfHtmlAcivity.progress != null && PdfHtmlAcivity.progress.isShowing()) {
                PdfHtmlAcivity.progress.dismiss();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.cancel();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            result.cancel();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            result.cancel();
            return true;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
