package com.appnew.android.Webview;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.table.UserHistroyTable;
import com.eduteria.app.app.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class WebViewActivty extends AppCompatActivity {
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final String HTML_ENTITY = "&[a-zA-Z][a-zA-Z0-9]+;";
    public static final int REQUEST_SELECT_FILE = 100;
    public static final String TAG_END = "</\\w+>";
    public static final String TAG_SELF_CLOSING = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>";
    public static final String TAG_START = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>";
    public static final Pattern htmlPattern = Pattern.compile("(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>.*</\\w+>)|(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>)|(&[a-zA-Z][a-zA-Z0-9]+;)", 32);
    private static Progress progress;
    private String downloadAvailable;
    private ImageView downloadContent;
    private ImageView image_back;
    Toolbar main_toolbar;
    TextView toolbarTitleTV;
    public ValueCallback<Uri[]> uploadMessage;
    private String urlContent;
    String video_id;
    private WebView webView;
    private boolean isLoaded = false;
    String file_type = "";
    String link = "";
    String course_id = "";
    private boolean isErrorDialogShown = false;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.webview_activity);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            WebView webView = (WebView) findViewById(R.id.webresourcewebview);
            this.webView = webView;
            configureWebView(webView);
            getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: com.appnew.android.Webview.WebViewActivty.1
                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    if (WebViewActivty.this.webView != null && WebViewActivty.this.webView.canGoBack()) {
                        WebViewActivty.this.webView.goBack();
                    } else {
                        WebViewActivty.this.finish();
                    }
                }
            });
            this.webView.setHapticFeedbackEnabled(false);
            this.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.Webview.WebViewActivty.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View v) {
                    return true;
                }
            });
            this.webView.setLongClickable(false);
            this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
            this.main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            this.toolbarTitleTV.setSelected(true);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            this.downloadContent = (ImageView) findViewById(R.id.download_pdf);
            View viewFindViewById = findViewById(R.id.root);
            Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            if (Build.VERSION.SDK_INT == 36) {
                EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
            }
            this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Webview.WebViewActivty$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$0();
                }
            }));
            this.file_type = getIntent().getStringExtra("file_type") == null ? "" : getIntent().getStringExtra("file_type");
            this.toolbarTitleTV.setText(getIntent().getStringExtra("type"));
            this.video_id = getIntent().getStringExtra(Const.VIDEO_ID);
            this.link = getIntent().getStringExtra("link");
            this.urlContent = getIntent().getStringExtra("url");
            this.downloadAvailable = getIntent().getStringExtra("download_available");
            if (this.toolbarTitleTV.getText().equals(getResources().getString(R.string.terms_of_service)) || this.toolbarTitleTV.getText().equals(getResources().getString(R.string.privacy_policy)) || this.toolbarTitleTV.getText().equals(getResources().getString(R.string.refund_policy))) {
                this.webView.getSettings().setDefaultFontSize(50);
            }
            this.isLoaded = false;
            String stringExtra = getIntent().getStringExtra("course_id");
            this.course_id = stringExtra;
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.course_id = stringExtra;
            this.link = this.link == null ? "" : getIntent().getStringExtra("link");
            String str = this.video_id;
            this.video_id = (str == null || str.equalsIgnoreCase("")) ? getIntent().getStringExtra("type") : getIntent().getStringExtra(Const.VIDEO_ID);
            progress = new Progress(this);
            startChatBot(getIntent().getStringExtra("url"));
            String str2 = this.file_type;
            if (str2 != null && str2.equalsIgnoreCase("image")) {
                this.webView.getSettings().setSupportZoom(true);
                this.webView.getSettings().setBuiltInZoomControls(true);
                this.webView.getSettings().setDisplayZoomControls(false);
            }
        } catch (Exception e2) {
            if (progress.isShowing()) {
                progress.dismiss();
            }
            e2.printStackTrace();
        }
        openContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    private void openContent() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.toolbarTitleTV.getLayoutParams();
        marginLayoutParams.setMarginEnd((int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics()));
        String str = this.downloadAvailable;
        if (str != null && str.equalsIgnoreCase("1")) {
            this.downloadContent.setVisibility(0);
            this.toolbarTitleTV.setLayoutParams(marginLayoutParams);
            this.downloadContent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.WebViewActivty$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$openContent$1(view);
                }
            });
        } else {
            this.downloadContent.setVisibility(8);
        }
        String str2 = this.file_type;
        if (str2 != null && str2.equalsIgnoreCase("image")) {
            this.webView.loadDataWithBaseURL(null, "<html><body style='margin:0;padding:0;text-align:center;'><img src=\"" + this.urlContent + "\" style='width:100%;height:auto;'/></body></html>", Mimetypes.MIMETYPE_HTML, "UTF-8", null);
        } else {
            this.webView.loadUrl(this.urlContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openContent$1(View view) {
        if (!TextUtils.isEmpty(this.urlContent)) {
            downloadContent(this.urlContent);
        } else {
            Toast.makeText(this, "Download URL is empty", 0).show();
        }
    }

    private void downloadContent(String urlContent) {
        String string = getString(R.string.app_name);
        String stringExtra = getIntent().getStringExtra("type");
        if (stringExtra == null || stringExtra.trim().isEmpty()) {
            stringExtra = "file";
        }
        String strReplaceAll = stringExtra.replaceAll("[^a-zA-Z0-9_-]", "_");
        String strSubstring = strReplaceAll + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".jpg";
        if (strSubstring.length() > 150) {
            strSubstring = strSubstring.substring(0, 150);
        }
        if (strReplaceAll.length() > 50) {
            strReplaceAll = strReplaceAll.substring(0, 50);
        }
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlContent));
        request.setTitle(strReplaceAll);
        request.setDescription("Downloading " + strReplaceAll);
        request.setNotificationVisibility(1);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, string + MqttTopic.TOPIC_LEVEL_SEPARATOR + strSubstring);
        DownloadManager downloadManager = (DownloadManager) getSystemService("download");
        if (downloadManager != null) {
            downloadManager.enqueue(request);
        }
    }

    private void startChatBot(final String url) {
        Progress progress2 = progress;
        if (progress2 != null) {
            progress2.show();
        }
        if (TextUtils.isEmpty(url) || this.webView == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.link) && "8".equals(this.link)) {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.appnew.android.Webview.WebViewActivty$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startChatBot$2(url);
                }
            });
        }
        if (htmlPattern.matcher(url).find()) {
            this.webView.loadData(url, Mimetypes.MIMETYPE_HTML, "UTF-8");
            return;
        }
        if (!this.isLoaded) {
            this.webView.loadUrl(url);
        }
        this.webView.setDownloadListener(new DownloadListener() { // from class: com.appnew.android.Webview.WebViewActivty$$ExternalSyntheticLambda3
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                this.f$0.lambda$startChatBot$3(str, str2, str3, str4, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startChatBot$2(String str) {
        String strTrim;
        try {
            UserHistroyTable userHistroyTable = new UserHistroyTable();
            userHistroyTable.setVideo_id(this.video_id);
            TextView textView = this.toolbarTitleTV;
            if (textView != null) {
                strTrim = textView.getText().toString().trim();
            } else {
                strTrim = "";
            }
            userHistroyTable.setPdf_name(strTrim);
            userHistroyTable.setType("8");
            userHistroyTable.setPdf_url(str);
            userHistroyTable.setUser_id(MakeMyExam.userId);
            userHistroyTable.setCurrent_time(String.valueOf(MakeMyExam.getTime_server()));
            userHistroyTable.setCourse_id(this.course_id);
            UtkashRoom.getAppDatabase(this).getuserhistorydao().addUser(userHistroyTable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f A[Catch: all -> 0x008f, Exception -> 0x0091, TRY_ENTER, TryCatch #0 {Exception -> 0x0091, blocks: (B:4:0x0005, B:6:0x0011, B:13:0x002f, B:15:0x004f, B:16:0x0060, B:18:0x006f, B:19:0x0072), top: B:41:0x0005, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$startChatBot$3(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, long r5) {
        /*
            r0 = this;
            java.lang.String r2 = "Utkarsh_"
            r3 = 1
            if (r4 == 0) goto L2f
            java.lang.String r4 = r4.toLowerCase()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r5 = "pdf"
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r4 == 0) goto L2f
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r4 = "android.intent.action.VIEW"
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r2.<init>(r4, r1)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r0.startActivity(r2)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            com.appnew.android.Utils.Progress r1 = com.appnew.android.Webview.WebViewActivty.progress
            if (r1 == 0) goto Lb0
            boolean r1 = r1.isShowing()
            if (r1 == 0) goto Lb0
        L29:
            com.appnew.android.Utils.Progress r1 = com.appnew.android.Webview.WebViewActivty.progress
            r1.dismiss()
            return
        L2f:
            android.app.DownloadManager$Request r4 = new android.app.DownloadManager$Request     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            android.net.Uri r5 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r4.allowScanningByMediaScanner()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r4.setNotificationVisibility(r3)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r5 = 47
            int r5 = r1.lastIndexOf(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            int r5 = r5 + r3
            java.lang.String r1 = r1.substring(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r5 == 0) goto L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
        L60:
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r4.setDestinationInExternalPublicDir(r2, r1)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r1 = "download"
            java.lang.Object r1 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            android.app.DownloadManager r1 = (android.app.DownloadManager) r1     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r1 == 0) goto L72
            r1.enqueue(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
        L72:
            android.content.Context r1 = r0.getApplicationContext()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r2 = 2132017655(0x7f1401f7, float:1.9673595E38)
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r2, r3)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r1.show()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            com.appnew.android.Utils.Progress r1 = com.appnew.android.Webview.WebViewActivty.progress
            if (r1 == 0) goto Lb0
            boolean r1 = r1.isShowing()
            if (r1 == 0) goto Lb0
            goto L29
        L8f:
            r1 = move-exception
            goto Lb1
        L91:
            r1 = move-exception
            android.content.Context r2 = r0.getApplicationContext()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L8f
            android.widget.Toast r1 = android.widget.Toast.makeText(r2, r1, r3)     // Catch: java.lang.Throwable -> L8f
            r1.show()     // Catch: java.lang.Throwable -> L8f
            com.appnew.android.Utils.Progress r1 = com.appnew.android.Webview.WebViewActivty.progress
            if (r1 == 0) goto Lb0
            boolean r1 = r1.isShowing()
            if (r1 == 0) goto Lb0
            com.appnew.android.Utils.Progress r1 = com.appnew.android.Webview.WebViewActivty.progress
            r1.dismiss()
        Lb0:
            return
        Lb1:
            com.appnew.android.Utils.Progress r2 = com.appnew.android.Webview.WebViewActivty.progress
            if (r2 == 0) goto Lc0
            boolean r2 = r2.isShowing()
            if (r2 == 0) goto Lc0
            com.appnew.android.Utils.Progress r2 = com.appnew.android.Webview.WebViewActivty.progress
            r2.dismiss()
        Lc0:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Webview.WebViewActivty.lambda$startChatBot$3(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") == null || TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            return;
        }
        changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
    }

    public void changeThemeColor(String color) {
        if (!color.contains(":") || color.split(":").length <= 1) {
            return;
        }
        SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
        this.main_toolbar.setBackgroundColor(Color.parseColor(color.split(":")[0]));
        this.image_back.setColorFilter(Color.parseColor(color.split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.toolbarTitleTV.setTextColor(Color.parseColor(color.split(":")[1]));
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(Color.parseColor(color.split(":")[0]));
    }

    private void configureWebView(final WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setClickable(true);
        webView.setLongClickable(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.getSettings().setAllowContentAccess(true);
        webView.setWebChromeClient(new ChatBotChromeClient());
        WebView.setWebContentsDebuggingEnabled(false);
    }

    public class CustomWebViewClient extends WebViewClient {
        public CustomWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (WebViewActivty.progress != null && !WebViewActivty.progress.isShowing()) {
                WebViewActivty.progress.show();
            }
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (WebViewActivty.progress != null && !WebViewActivty.progress.isShowing()) {
                WebViewActivty.progress.show();
            }
            view.loadUrl(url);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            WebViewActivty.this.isErrorDialogShown = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            if ((request != null && !request.isForMainFrame()) || WebViewActivty.this.isFinishing() || WebViewActivty.this.isErrorDialogShown) {
                return;
            }
            if (WebViewActivty.progress != null && WebViewActivty.progress.isShowing()) {
                WebViewActivty.progress.dismiss();
            }
            if (!Helper.isNetworkConnected(WebViewActivty.this)) {
                WebViewActivty.this.isErrorDialogShown = true;
                WebViewActivty.this.showNetworkErrorDialog();
            } else if (WebViewActivty.this.webView.canGoBack()) {
                WebViewActivty.this.webView.goBack();
            } else {
                WebViewActivty.this.webView.loadUrl("about:blank");
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            if (WebViewActivty.progress == null || !WebViewActivty.progress.isShowing()) {
                return;
            }
            WebViewActivty.progress.dismiss();
            WebViewActivty.this.isLoaded = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetworkErrorDialog() {
        new MaterialAlertDialogBuilder(this).setTitle(R.string.error).setMessage(R.string.check_your_internet_connection_and_try_again).setCancelable(false).setPositiveButton(R.string.try_again, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Webview.WebViewActivty$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showNetworkErrorDialog$4(dialogInterface, i);
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Webview.WebViewActivty$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showNetworkErrorDialog$5(dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetworkErrorDialog$4(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.isErrorDialogShown = false;
        this.webView.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetworkErrorDialog$5(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        finish();
    }

    class ChatBotChromeClient extends WebChromeClient {
        ChatBotChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (WebViewActivty.this.uploadMessage != null) {
                WebViewActivty.this.uploadMessage.onReceiveValue(null);
            }
            WebViewActivty.this.uploadMessage = filePathCallback;
            fileChooserParams.getAcceptTypes();
            try {
                WebViewActivty.this.startActivityForResult(fileChooserParams.createIntent(), 100);
                return true;
            } catch (ActivityNotFoundException unused) {
                WebViewActivty.this.uploadMessage = null;
                WebViewActivty webViewActivty = WebViewActivty.this;
                Toast.makeText(webViewActivty, webViewActivty.getResources().getString(R.string.cannot_open_file_chooser), 1).show();
                return false;
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(final PermissionRequest request) {
            request.grant(request.getResources());
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage cm) {
            if (cm == null) {
                return true;
            }
            cm.sourceId();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 100) {
            if (this.uploadMessage == null) {
                return;
            }
            this.uploadMessage.onReceiveValue((resultCode != -1 || intent == null) ? null : WebChromeClient.FileChooserParams.parseResult(resultCode, intent));
            this.uploadMessage = null;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.stopLoading();
            this.webView.setWebViewClient(null);
            this.webView.setWebChromeClient(null);
            this.webView.destroy();
            this.webView = null;
        }
        super.onDestroy();
    }
}
