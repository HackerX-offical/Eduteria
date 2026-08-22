package com.appnew.android.Login.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.appnew.android.Login.Activity.SignInActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Progress;
import com.eduteria.app.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class CommonWebViewFragment extends Fragment {
    ImageView iv_back;
    private Progress progress;
    WebView webview;
    private String strUrl = "";
    private boolean showToolbar = false;

    public static CommonWebViewFragment newInstance(String url, boolean showToolbar) {
        CommonWebViewFragment commonWebViewFragment = new CommonWebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Const.PRIVACYURL, url);
        bundle.putBoolean("show_toolbar", showToolbar);
        commonWebViewFragment.setArguments(bundle);
        return commonWebViewFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.strUrl = getArguments().getString(Const.PRIVACYURL);
            this.showToolbar = getArguments().getBoolean("show_toolbar");
        }
        try {
            Progress progress = new Progress(getActivity());
            this.progress = progress;
            if (progress.isShowing()) {
                return;
            }
            this.progress.show();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_common_web_view, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() instanceof SignInActivity) {
            Window window = getActivity().getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        WebView webView = (WebView) view.findViewById(R.id.web_view);
        this.webview = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setLoadsImagesAutomatically(true);
        this.webview.setHorizontalScrollBarEnabled(true);
        this.webview.setVerticalScrollBarEnabled(true);
        this.webview.setScrollBarStyle(0);
        this.webview.setWebChromeClient(new WebChromeClient());
        this.webview.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.Login.Fragment.CommonWebViewFragment.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view2, String url, Bitmap favicon) {
                super.onPageStarted(view2, url, favicon);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view2, String url) {
                super.onPageFinished(view2, url);
                CommonWebViewFragment.this.webview.setVisibility(0);
                if (CommonWebViewFragment.this.progress.isShowing()) {
                    CommonWebViewFragment.this.progress.dismiss();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view2, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view2, errorCode, description, failingUrl);
                CommonWebViewFragment.this.webview.setVisibility(8);
                if (CommonWebViewFragment.this.progress.isShowing()) {
                    CommonWebViewFragment.this.progress.dismiss();
                }
            }
        });
        this.webview.loadUrl(this.strUrl);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        this.iv_back = imageView;
        imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.CommonWebViewFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$0();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$0() {
        requireActivity().onBackPressed();
        return null;
    }

    public void reloadWebView() {
        this.webview.reload();
    }

    public WebView getWebview() {
        return this.webview;
    }
}
