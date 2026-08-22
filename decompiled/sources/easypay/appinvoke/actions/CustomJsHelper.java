package easypay.appinvoke.actions;

import android.app.Activity;
import android.webkit.WebView;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class CustomJsHelper {
    Map<String, String> action;
    Activity activity;
    EasypayBrowserFragment fragment;
    WebView webview;

    public CustomJsHelper(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        this.activity = activity;
        this.fragment = easypayBrowserFragment;
        this.action = map;
        this.webview = webView;
        this.webview.loadUrl("javascript:" + this.action.get("functionStart") + this.action.get("functionEnd"));
    }
}
