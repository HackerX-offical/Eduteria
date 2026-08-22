package a.a.c;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.billdesk.sdk.PaymentWebView;

/* JADX INFO: loaded from: classes.dex */
public class i extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaymentWebView f159a;

    public i(PaymentWebView paymentWebView) {
        this.f159a = paymentWebView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        PaymentWebView paymentWebView = this.f159a;
        if (paymentWebView.f419d) {
            ((a.a.a.a) paymentWebView.f418c).setIsPageLoaded(true);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f159a.f420e.setVisibility(0);
        String str2 = this.f159a.f416a;
        String str3 = "OnPageStarted==" + str;
        PaymentWebView paymentWebView = this.f159a;
        if (paymentWebView.f419d) {
            ((a.a.a.a) paymentWebView.f418c).setIsPageLoaded(false);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f159a.i.equalsIgnoreCase("Y")) {
            this.f159a.a(sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
