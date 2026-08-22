package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.clevertap.android.sdk.network.api.CtApi;
import com.eduteria.app.app.R;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class QuizWebView extends AppCompatActivity {
    private TextView errorTV;
    String lang;
    NetworkCall networkCall;
    Progress progressBar;
    QuizModel quiz;
    String quizID;
    ResultTestSeries resultTestSeries;
    String url;
    WebView webView;
    String TAG = "QuizWebView";
    String practiceId = "";
    String subjectiveid = "";
    String quizState = "";
    String questionid = null;
    String reportid = null;
    boolean status = false;
    boolean isReattempt = false;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_quiz_web_view);
        this.webView = (WebView) findViewById(R.id.webView);
        this.errorTV = (TextView) findViewById(R.id.errorTV);
        this.progressBar = new Progress(this);
        this.quizID = getIntent().getExtras().getString(Const.QUIZSTATUS);
        this.quizState = getIntent().getExtras().getString(Const.TESTSTATE);
        this.resultTestSeries = (ResultTestSeries) getIntent().getExtras().getSerializable(Const.RESULT_SCREEN);
        this.status = getIntent().getExtras().getBoolean("status");
        this.isReattempt = getIntent().getExtras().getBoolean(Const.IS_REATTEMPT);
        this.lang = String.valueOf(getIntent().getExtras().getInt("id"));
        this.subjectiveid = getIntent().getExtras().getString("subjectiveid");
        if (getIntent().hasExtra(Const.PRACTICE_ID)) {
            this.practiceId = getIntent().getStringExtra(Const.PRACTICE_ID);
        }
        this.reportid = getIntent().getStringExtra("report_id");
        this.questionid = getIntent().getStringExtra("q_id");
        getWindow().addFlags(Integer.MIN_VALUE);
        this.progressBar.setCancelable(false);
        this.progressBar.show();
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setPluginState(WebSettings.PluginState.ON);
        this.webView.addJavascriptInterface(new WebAppInterface(this), CtApi.DEFAULT_QUERY_PARAM_OS);
        this.webView.setLayerType(2, null);
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.Courses.Fragment.QuizWebView.1
            boolean returnVal = false;

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                if (QuizWebView.this.progressBar.isShowing()) {
                    QuizWebView.this.progressBar.dismiss();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                if (url.contains("back_true")) {
                    Constants.REFRESHFEED = "true";
                    QuizWebView.this.finish();
                }
                super.doUpdateVisitedHistory(view, url, isReload);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!QuizWebView.this.status) {
                    if (url.contains("leaderboard")) {
                        Uri uri = Uri.parse(url);
                        String queryParameter = uri.getQueryParameter(Const.TESTSEGMENT_ID);
                        uri.getQueryParameter("user_id");
                        this.returnVal = true;
                        if (QuizWebView.this.progressBar.isShowing()) {
                            QuizWebView.this.progressBar.dismiss();
                        }
                        Intent intent = new Intent(QuizWebView.this, (Class<?>) QuizActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.LEADERBOARD);
                        intent.putExtra(Const.PRACTICE, queryParameter);
                        QuizWebView.this.startActivity(intent);
                    } else if (url.endsWith(".pdf")) {
                        QuizWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                        return true;
                    }
                }
                return this.returnVal;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                if (QuizWebView.this.progressBar != null && QuizWebView.this.progressBar.isShowing()) {
                    QuizWebView.this.progressBar.dismiss();
                }
                QuizWebView.this.webView.setVisibility(8);
                QuizWebView.this.errorTV.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });
        if (TextUtils.isEmpty(this.subjectiveid)) {
            if (!Helper.isStringValid(this.lang) || !TextUtils.isEmpty(this.practiceId)) {
                this.webView.loadUrl(String.format("%sdata_model/courses/test_web/view?test_series_id=%s&user_id=%s&test_type=practice&lang=%s&Jwt=%s", "https://appapi.videocrypt.in/index.php/", this.practiceId, SharedPreference.getInstance().getLoggedInUser().getId(), Integer.valueOf(SharedPreference.getInstance().getInt(Const.LANGUAGE)), SharedPreference.getInstance().getString(Const.JWT)));
                return;
            }
            if (!this.status && this.reportid == null) {
                if (this.isReattempt) {
                    this.webView.loadUrl(String.format("%sdata_model/courses/test_web/view?test_series_id=%s&user_id=%s&lang=%s&Jwt=%s&re_attempt=%s", "https://appapi.videocrypt.in/index.php/", this.quizID, SharedPreference.getInstance().getLoggedInUser().getId(), this.lang, SharedPreference.getInstance().getString(Const.JWT), "1"));
                    return;
                }
                if (!TextUtils.isEmpty(this.quizState)) {
                    if (this.quizState.equalsIgnoreCase("1")) {
                        this.webView.loadUrl(String.format("%sdata_model/courses/test_web/view?test_series_id=%s&user_id=%s&lang=%s&Jwt=%s", "https://appapi.videocrypt.in/index.php/", this.quizID, SharedPreference.getInstance().getLoggedInUser().getId(), this.lang, SharedPreference.getInstance().getString(Const.JWT)));
                        return;
                    } else if (this.quizState.equalsIgnoreCase("0")) {
                        this.webView.loadUrl(String.format("%sdata_model/courses/test_web/view?test_series_id=%s&user_id=%s&lang=%s&Jwt=%s&state=%s", "https://appapi.videocrypt.in/index.php/", this.quizID, SharedPreference.getInstance().getLoggedInUser().getId(), this.lang, SharedPreference.getInstance().getString(Const.JWT), "resume"));
                        return;
                    } else {
                        this.webView.loadUrl(String.format("%sdata_model/courses/test_web/view?test_series_id=%s&user_id=%s&lang=%s&Jwt=%s&state=%s", "https://appapi.videocrypt.in/index.php/", this.quizID, SharedPreference.getInstance().getLoggedInUser().getId(), this.lang, SharedPreference.getInstance().getString(Const.JWT), ES6Iterator.DONE_PROPERTY));
                        return;
                    }
                }
                this.webView.loadUrl(String.format("%sdata_model/courses/test_web/view?test_series_id=%s&user_id=%s&lang=%s&Jwt=%s&state=%s", "https://appapi.videocrypt.in/index.php/", this.quizID, SharedPreference.getInstance().getLoggedInUser().getId(), this.lang, SharedPreference.getInstance().getString(Const.JWT), ES6Iterator.DONE_PROPERTY));
                return;
            }
            if (this.reportid != null) {
                this.webView.loadUrl(String.format("https://appapi.videocrypt.in/index.php/data_model/courses/test_web/open_view_from_quesion?report_id=" + this.reportid + "&q_id=" + this.questionid + "&Jwt=" + SharedPreference.getInstance().getString(Const.JWT) + "&user_id=" + SharedPreference.getInstance().getLoggedInUser().getId(), new Object[0]) + "&lang=" + this.lang);
                return;
            }
            return;
        }
        this.webView.loadUrl(String.format("%sdata_model/courses/test_web/subjective_result?report_id=%s&user_id=%s&lang=%s&Jwt=%s", "https://appapi.videocrypt.in/index.php/", this.subjectiveid, SharedPreference.getInstance().getLoggedInUser().getId(), this.lang, SharedPreference.getInstance().getString(Const.JWT)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == 0 && keyCode == 4) {
            if (this.webView.canGoBack()) {
                if (Helper.isNetworkConnected(this)) {
                    if (this.webView.getUrl().contains("test_web/result")) {
                        Constants.REFRESHFEED = "true";
                        finish();
                        return true;
                    }
                    this.webView.evaluateJavascript("back_pressed();", null);
                    return true;
                }
                Constants.REFRESHFEED = "true";
                finish();
                return true;
            }
            if (Helper.isNetworkConnected(this)) {
                this.webView.evaluateJavascript("back_pressed();", null);
                return true;
            }
            Constants.REFRESHFEED = "true";
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyJavaScriptInterface {
        WebView webView;

        @JavascriptInterface
        public void processHTML(String html) {
        }

        public MyJavaScriptInterface(WebView webView) {
            this.webView = webView;
        }
    }

    public class WebAppInterface {
        Activity mContext;

        public WebAppInterface(Activity c2) {
            this.mContext = c2;
        }

        @JavascriptInterface
        public void getURL(final String url) {
            this.mContext.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Fragment.QuizWebView.WebAppInterface.1
                @Override // java.lang.Runnable
                public void run() {
                    QuizWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
