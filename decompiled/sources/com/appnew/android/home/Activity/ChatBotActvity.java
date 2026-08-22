package com.appnew.android.home.Activity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class ChatBotActvity extends AppCompatActivity {
    WebView chatbotwebview;
    ImageView image_back;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_chat_bot_actvity);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorWhite));
            this.chatbotwebview = (WebView) findViewById(R.id.chatbotwebview);
            ImageView imageView = (ImageView) findViewById(R.id.image_back);
            this.image_back = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.ChatBotActvity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ChatBotActvity.this.finish();
                }
            });
            startChatBot();
        } catch (Exception e2) {
            Helper.dismissProgressDialog();
            e2.printStackTrace();
        }
    }

    private void configureWebView(final WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setClickable(true);
        webView.setLongClickable(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setScrollBarStyle(GroupFlagsKt.HasAuxSlotFlag);
        webView.setScrollbarFadingEnabled(false);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setLayerType(2, null);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        WebView.setWebContentsDebuggingEnabled(false);
    }

    private void startChatBot() {
        Helper.showProgressDialog(this);
        configureWebView(this.chatbotwebview);
        this.chatbotwebview.loadUrl("https://ailifebot.com/utkarsh-classes.html?username=" + SharedPreference.getInstance().getLoggedInUser().getMobile());
    }

    public class CustomWebViewClient extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
        }

        public CustomWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            try {
                ChatBotActvity.this.chatbotwebview.stopLoading();
            } catch (Exception unused) {
            }
            if (ChatBotActvity.this.chatbotwebview.canGoBack()) {
                ChatBotActvity.this.chatbotwebview.goBack();
            }
            ChatBotActvity.this.chatbotwebview.loadUrl("about:blank");
            AlertDialog alertDialogCreate = new AlertDialog.Builder(ChatBotActvity.this).create();
            alertDialogCreate.setTitle(ChatBotActvity.this.getResources().getString(R.string.error));
            alertDialogCreate.setMessage(ChatBotActvity.this.getResources().getString(R.string.check_your_internet_connection_and_try_again));
            alertDialogCreate.setButton(-1, ChatBotActvity.this.getResources().getString(R.string.try_again), new DialogInterface.OnClickListener() { // from class: com.appnew.android.home.Activity.ChatBotActvity$CustomWebViewClient$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onReceivedError$0(dialogInterface, i);
                }
            });
            alertDialogCreate.show();
            super.onReceivedError(view, request, error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedError$0(DialogInterface dialogInterface, int i) {
            ChatBotActvity.this.finish();
            ChatBotActvity chatBotActvity = ChatBotActvity.this;
            chatBotActvity.startActivity(chatBotActvity.getIntent());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
        }
    }
}
