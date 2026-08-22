package a.a.c;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.billdesk.sdk.PaymentWebView;
import com.billdesk.utils.Helper;
import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public class j extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaymentWebView f160a;

    public j(PaymentWebView paymentWebView) {
        this.f160a = paymentWebView;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (Helper.a(webView.getUrl()).equals("NA")) {
            return;
        }
        if (!this.f160a.f417b.contains(webView.getUrl()) && i > 20) {
            String str = this.f160a.f416a;
            String str2 = "Progress done [" + webView.getUrl() + "][" + i + Constants.AES_SUFFIX;
            this.f160a.f417b.add(webView.getUrl());
        }
        if (i == 100) {
            this.f160a.f420e.setVisibility(8);
            this.f160a.f418c.setVisibility(0);
        }
    }
}
