package com.appnew.android.home.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Activity.HomeActivity;
import com.eduteria.app.app.R;
import com.paytm.pgsdk.Constants;

/* JADX INFO: loaded from: classes6.dex */
public class Chatboot extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final int REQUEST_SELECT_FILE = 100;
    WebView chatbotwebview;
    ImageView image_back;
    private String mParam1;
    private String mParam2;
    private ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> uploadMessage;

    public static Chatboot newInstance(String param1, String param2) {
        Chatboot chatboot = new Chatboot();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, param1);
        bundle.putString(ARG_PARAM2, param2);
        chatboot.setArguments(bundle);
        return chatboot;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Window window = getActivity().getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chatboot, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            this.chatbotwebview = (WebView) view.findViewById(R.id.chatbotwebview);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_back);
            this.image_back = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Fragment.Chatboot.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ((HomeActivity) Chatboot.this.getActivity()).closschatbot();
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
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setLayerType(2, null);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.setWebChromeClient(new ChatBotChromeClient());
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        WebView.setWebContentsDebuggingEnabled(false);
    }

    private void startChatBot() {
        Helper.showProgressDialog(getActivity());
        configureWebView(this.chatbotwebview);
        this.chatbotwebview.loadUrl("https://ailifebot.com/utkarsh-classes.html?username=" + SharedPreference.getInstance().getLoggedInUser().getMobile());
    }

    public class CustomWebViewClient extends WebViewClient {
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
                Chatboot.this.chatbotwebview.stopLoading();
            } catch (Exception unused) {
            }
            if (Chatboot.this.chatbotwebview.canGoBack()) {
                Chatboot.this.chatbotwebview.goBack();
            }
            Helper.dismissProgressDialog();
            Chatboot.this.chatbotwebview.loadUrl("about:blank");
            AlertDialog alertDialogCreate = new AlertDialog.Builder(Chatboot.this.getContext()).create();
            alertDialogCreate.setTitle(Constants.EVENT_ACTION_ERROR);
            alertDialogCreate.setMessage("Check your internet connection and try again.");
            alertDialogCreate.setButton(-1, "Try Again", new DialogInterface.OnClickListener() { // from class: com.appnew.android.home.Fragment.Chatboot$CustomWebViewClient$$ExternalSyntheticLambda0
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
            Chatboot.this.getActivity().finish();
            Chatboot chatboot = Chatboot.this;
            chatboot.startActivity(chatboot.getActivity().getIntent());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Helper.dismissProgressDialog();
        }
    }

    class ChatBotChromeClient extends WebChromeClient {
        ChatBotChromeClient() {
        }

        protected void openFileChooser(ValueCallback uploadMsg, String acceptType) {
            Chatboot.this.mUploadMessage = uploadMsg;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (Chatboot.this.uploadMessage != null) {
                Chatboot.this.uploadMessage.onReceiveValue(null);
                Chatboot.this.uploadMessage = null;
            }
            Chatboot.this.uploadMessage = filePathCallback;
            fileChooserParams.getAcceptTypes();
            fileChooserParams.createIntent();
            return true;
        }

        protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            Chatboot.this.mUploadMessage = uploadMsg;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
        }

        protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
            Chatboot.this.mUploadMessage = uploadMsg;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
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
            cm.sourceId().length();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 100) {
            ValueCallback<Uri[]> valueCallback = this.uploadMessage;
            if (valueCallback == null) {
                return;
            }
            valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, intent));
            this.uploadMessage = null;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }
}
