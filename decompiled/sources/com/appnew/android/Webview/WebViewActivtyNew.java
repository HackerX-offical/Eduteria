package com.appnew.android.Webview;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import java.io.File;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class WebViewActivtyNew extends AppCompatActivity {
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final String HTML_ENTITY = "&[a-zA-Z][a-zA-Z0-9]+;";
    public static final int REQUEST_SELECT_FILE = 100;
    public static final String TAG_END = "</\\w+>";
    public static final String TAG_SELF_CLOSING = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>";
    public static final String TAG_START = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>";
    public static final Pattern htmlPattern = Pattern.compile("(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>.*</\\w+>)|(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>)|(&[a-zA-Z][a-zA-Z0-9]+;)", 32);
    private static Progress progress;
    private ImageView downarrowFB;
    private Button download_btn;
    private boolean errortry;
    private ImageView image_back;
    private ProgressDialog mProgressDialog;
    private ValueCallback<Uri> mUploadMessage;
    private String thumbnail;
    TextView toolbarTitleTV;
    public ValueCallback<Uri[]> uploadMessage;
    String video_id;
    private WebView webView;
    private boolean isLoaded = false;
    String file_type = "";
    String pdf_id = "";
    String name = "";
    String link = "";
    String course_id = "";
    String url = "";
    String title = "";
    private boolean saved = false;
    private boolean download_file = false;
    private boolean isDownload = false;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.webview_activity);
        if (getIntent().getExtras() != null) {
            this.url = getIntent().getStringExtra("url");
            this.file_type = getIntent().getStringExtra("file_type");
            this.title = getIntent().getStringExtra("title");
            this.thumbnail = getIntent().getStringExtra(Const.THUMBNAIL);
            this.saved = getIntent().getBooleanExtra("save", false);
            this.download_file = getIntent().getBooleanExtra("download_file", false);
            this.isDownload = getIntent().getBooleanExtra(Const.IS_DOWNLOAD, false);
        }
        this.webView = (WebView) findViewById(R.id.webresourcewebview);
        this.downarrowFB = (ImageView) findViewById(R.id.download_pdf);
        this.download_btn = (Button) findViewById(R.id.procceed_btn);
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        WebView webView = (WebView) findViewById(R.id.webresourcewebview);
        this.webView = webView;
        webView.setHapticFeedbackEnabled(false);
        this.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.Webview.WebViewActivtyNew.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                return true;
            }
        });
        configureWebView(this.webView);
        this.webView.setLongClickable(false);
        TextView textView = (TextView) findViewById(R.id.toolbarTitleTV);
        this.toolbarTitleTV = textView;
        textView.setText(this.title);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        View viewFindViewById = findViewById(R.id.root);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Webview.WebViewActivtyNew$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.webView.getSettings().setJavaScriptEnabled(true);
        if (this.file_type.equalsIgnoreCase("cumulative_url")) {
            this.webView.loadUrl(this.url + SharedPreference.getInstance().getLoggedInUser().getId());
        } else if (this.file_type.equalsIgnoreCase("zoom_url")) {
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.getSettings().setDomStorageEnabled(true);
            this.webView.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.Webview.WebViewActivtyNew.2
                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (!url.contains("zoom.us")) {
                        return false;
                    }
                    WebViewActivtyNew.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                }
            });
            this.webView.loadUrl(this.url);
        } else {
            this.webView.setWebViewClient(new CustomWebViewClientNew());
            this.webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + this.url);
        }
        if (this.isDownload) {
            if (getIntent().hasExtra("cat_type") && getIntent().getStringExtra("cat_type").equalsIgnoreCase("3")) {
                this.download_btn.setVisibility(0);
            } else {
                this.downarrowFB.setVisibility(0);
            }
        }
        this.downarrowFB.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.WebViewActivtyNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Helper.isNetworkConnected(WebViewActivtyNew.this)) {
                    if (WebViewActivtyNew.this.getFileExist().exists()) {
                        String str = WebViewActivtyNew.this.pdf_id + ".pdf";
                        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
                            new File(WebViewActivtyNew.this.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str).delete();
                        } else {
                            new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/EDUTERIA_doc_folder/" + str).delete();
                        }
                    }
                    WebViewActivtyNew.this.mProgressDialog = new ProgressDialog(WebViewActivtyNew.this);
                    WebViewActivtyNew.this.mProgressDialog.setMessage("Download Pdf");
                    WebViewActivtyNew.this.mProgressDialog.setIndeterminate(true);
                    WebViewActivtyNew.this.mProgressDialog.setProgressStyle(1);
                    WebViewActivtyNew.this.mProgressDialog.setCancelable(false);
                    Log.e("SATYA_TEST_VERSION_CODE", "onClick: 53");
                    WebViewActivtyNew webViewActivtyNew = WebViewActivtyNew.this;
                    final DownloadTask downloadTask = webViewActivtyNew.new DownloadTask(webViewActivtyNew);
                    downloadTask.execute(WebViewActivtyNew.this.url);
                    WebViewActivtyNew.this.mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.Webview.WebViewActivtyNew.3.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialog) {
                            downloadTask.cancel(true);
                        }
                    });
                    return;
                }
                WebViewActivtyNew webViewActivtyNew2 = WebViewActivtyNew.this;
                Toast.makeText(webViewActivtyNew2, webViewActivtyNew2.getResources().getString(R.string.no_internet_connection), 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    private class DownloadTask extends AsyncTask<String, Integer, String> {
        private Context context;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            WebViewActivtyNew.this.mProgressDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate((Object[]) progress);
            try {
                WebViewActivtyNew.this.mProgressDialog.setIndeterminate(false);
                WebViewActivtyNew.this.mProgressDialog.setMax(100);
                WebViewActivtyNew.this.mProgressDialog.setProgress(progress[0].intValue());
            } catch (IllegalArgumentException e2) {
                Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e2.getMessage());
            } catch (Exception e3) {
                Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e3.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            WebViewActivtyNew.this.download_btn.setClickable(true);
            WebViewActivtyNew.this.mProgressDialog.dismiss();
            if (result != null) {
                Toast.makeText(this.context, WebViewActivtyNew.this.getResources().getString(R.string.download_error) + result, 1).show();
                return;
            }
            WebViewActivtyNew.this.downarrowFB.setEnabled(false);
            WebViewActivtyNew.this.downarrowFB.setImageResource(R.drawable.ic_downloaded_chapter);
            String str = WebViewActivtyNew.this.name + "_" + WebViewActivtyNew.this.course_id.replace(MqttTopic.MULTI_LEVEL_WILDCARD, "_") + WebViewActivtyNew.this.pdf_id + ".pdf";
            if (WebViewActivtyNew.this.getIntent().hasExtra("cat_type") && WebViewActivtyNew.this.getIntent().getStringExtra("cat_type").equalsIgnoreCase("3")) {
                Toast.makeText(this.context, "Your admit card has been downloaded successfully.", 0).show();
            } else {
                Toast.makeText(this.context, WebViewActivtyNew.this.getResources().getString(R.string.file_downloaded), 0).show();
            }
            WebViewActivtyNew.this.download_btn.setText("View PDF");
            WebViewActivtyNew.this.download_btn.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0194, code lost:
        
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0197, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x019a, code lost:
        
            if (r9 == null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x019c, code lost:
        
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x019f, code lost:
        
            r20.this$0.download_btn.setClickable(r4);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:107:0x020c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:120:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0211 A[Catch: IOException -> 0x021e, TryCatch #15 {IOException -> 0x021e, blocks: (B:73:0x020c, B:75:0x0211, B:76:0x0214), top: B:107:0x020c }] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0220  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x022c A[Catch: IOException -> 0x0239, TryCatch #0 {IOException -> 0x0239, blocks: (B:82:0x0227, B:84:0x022c, B:85:0x022f), top: B:94:0x0227 }] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x023b  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0227 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v16, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v8 */
        /* JADX WARN: Type inference failed for: r5v9 */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 575
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Webview.WebViewActivtyNew.DownloadTask.doInBackground(java.lang.String[]):java.lang.String");
        }
    }

    public File getFileExist() {
        String str = this.pdf_id + ".pdf";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
            return new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str);
        }
        return new File(file + "/EDUTERIA_doc_folder/" + str);
    }

    private static class CustomWebViewClientNew extends WebViewClient {
        private CustomWebViewClientNew() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.endsWith(".pdf")) {
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    private void configureWebView(final WebView webView) {
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
        webView.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.Webview.WebViewActivtyNew.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            }
        });
        webView.getSettings().setAllowContentAccess(true);
        WebView.setWebContentsDebuggingEnabled(false);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.getOnBackPressedDispatcher().onBackPressed();
    }

    public class CustomWebViewClient extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }

        public CustomWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            if (Helper.isNetworkConnected(WebViewActivtyNew.this) && !WebViewActivtyNew.this.isFinishing()) {
                try {
                    WebViewActivtyNew.this.webView.stopLoading();
                } catch (Exception unused) {
                }
                if (WebViewActivtyNew.this.webView.canGoBack()) {
                    WebViewActivtyNew.this.webView.goBack();
                }
                if (WebViewActivtyNew.this.errortry) {
                    if (WebViewActivtyNew.progress != null && WebViewActivtyNew.progress.isShowing()) {
                        WebViewActivtyNew.progress.dismiss();
                    }
                    WebViewActivtyNew.this.webView.loadUrl("about:blank");
                    AlertDialog alertDialogCreate = new AlertDialog.Builder(WebViewActivtyNew.this).create();
                    alertDialogCreate.setTitle(R.string.error);
                    alertDialogCreate.setMessage(WebViewActivtyNew.this.getResources().getString(R.string.check_your_internet_connection_and_try_again));
                    alertDialogCreate.setButton(-1, WebViewActivtyNew.this.getResources().getString(R.string.try_again), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Webview.WebViewActivtyNew$CustomWebViewClient$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onReceivedError$0(dialogInterface, i);
                        }
                    });
                    alertDialogCreate.show();
                } else {
                    WebViewActivtyNew.this.finish();
                    WebViewActivtyNew webViewActivtyNew = WebViewActivtyNew.this;
                    webViewActivtyNew.startActivity(webViewActivtyNew.getIntent());
                    WebViewActivtyNew.this.errortry = true;
                }
            }
            super.onReceivedError(view, request, error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedError$0(DialogInterface dialogInterface, int i) {
            WebViewActivtyNew.this.finish();
            WebViewActivtyNew webViewActivtyNew = WebViewActivtyNew.this;
            webViewActivtyNew.startActivity(webViewActivtyNew.getIntent());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            if (WebViewActivtyNew.progress == null || !WebViewActivtyNew.progress.isShowing()) {
                return;
            }
            WebViewActivtyNew.progress.dismiss();
            WebViewActivtyNew.this.isLoaded = true;
        }
    }
}
