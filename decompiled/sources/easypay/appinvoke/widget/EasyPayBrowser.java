package easypay.appinvoke.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import easypay.appinvoke.clients.EasypayWebChromeClient;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasypayWebViewClient;

/* JADX INFO: loaded from: classes9.dex */
public class EasyPayBrowser extends WebView {
    public EasyPayBrowser(Context context) {
        super(context);
    }

    public EasyPayBrowser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) throws IllegalArgumentException {
        if (str.equals(Constants.JsString)) {
            super.addJavascriptInterface(obj, str);
            return;
        }
        throw new IllegalArgumentException("Cannot use String other than JsString");
    }

    public void enableJsInterface(Object obj) {
        addJavascriptInterface(obj, Constants.JsString);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) throws IllegalArgumentException {
        if (webViewClient instanceof EasypayWebViewClient) {
            super.setWebViewClient(webViewClient);
            return;
        }
        throw new IllegalArgumentException("WebViewClient doesn't extends from EasyPayWebViewClient");
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) throws IllegalArgumentException {
        if (webChromeClient instanceof EasypayWebChromeClient) {
            super.setWebChromeClient(webChromeClient);
            return;
        }
        throw new IllegalArgumentException("WebviewClient doesn't extends from EasypayWebChromeClient");
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (str.equals(Constants.JsString)) {
            super.removeJavascriptInterface(str);
            return;
        }
        throw new IllegalArgumentException("Cannot use String other than JsString");
    }
}
